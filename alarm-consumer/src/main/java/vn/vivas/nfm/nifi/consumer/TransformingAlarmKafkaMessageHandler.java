package vn.vivas.nfm.nifi.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vn.vivas.nfm.nifi.consumer.config.KafkaConsumerConfig;
import vn.vivas.nfm.nifi.exception.AlarmMappingException;
import vn.vivas.nfm.nifi.model.Alarm;
import vn.vivas.nfm.nifi.service.AlarmTransformService;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class TransformingAlarmKafkaMessageHandler implements AlarmMessageHandler, AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(TransformingAlarmKafkaMessageHandler.class.getName());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Producer<String, String> producer;
    private final KafkaConsumerConfig config;
    private final AlarmTransformService transformService;

    public TransformingAlarmKafkaMessageHandler(KafkaConsumerConfig config, AlarmTransformService transformService) {
        this(new KafkaProducer<>(config.toProducerProperties()), config, transformService);
    }

    TransformingAlarmKafkaMessageHandler(
            Producer<String, String> producer,
            KafkaConsumerConfig config,
            AlarmTransformService transformService
    ) {
        this.producer = Objects.requireNonNull(producer, "producer must not be null");
        this.config = Objects.requireNonNull(config, "config must not be null");
        this.transformService = Objects.requireNonNull(transformService, "transformService must not be null");
    }

    @Override
    public void handle(ConsumerRecord<String, String> record) {
        Alarm alarm = transformService.transform(record.value());
        String alarmJson = serialize(alarm);
        ProducerRecord<String, String> outputRecord = new ProducerRecord<>(
                config.outputTopic(),
                record.key(),
                alarmJson
        );



        try {
            producer.send(outputRecord).get();
            LOGGER.info(() -> "Transformed alarm message"
                    + " inputTopic=" + record.topic()
                    + " outputTopic=" + config.outputTopic()
                    + " partition=" + record.partition()
                    + " offset=" + record.offset()
                    + " key=" + record.key());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AlarmMappingException("Interrupted while publishing transformed alarm", e);
        } catch (ExecutionException e) {
            throw new AlarmMappingException("Unable to publish transformed alarm", e);
        }
    }

    @Override
    public void close() {
        producer.close();
    }

    private String serialize(Alarm alarm) {
        try {
            return OBJECT_MAPPER.writeValueAsString(alarm);
        } catch (JsonProcessingException e) {
            throw new AlarmMappingException("Unable to serialize transformed alarm", e);
        }
    }
}
