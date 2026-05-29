package vn.vivas.nfm.nifi.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vn.vivas.nfm.nifi.consumer.config.KafkaConsumerConfig;
import vn.vivas.nfm.nifi.models.AlarmSNMPTrap;
import vn.vivas.nfm.nifi.parsers.JsonStringParser;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class TransformingAlarmKafkaMessageHandler implements AlarmMessageHandler, AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(TransformingAlarmKafkaMessageHandler.class.getName());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Producer<String, String> producer;
    private final KafkaConsumerConfig config;

    public TransformingAlarmKafkaMessageHandler(KafkaConsumerConfig config) {
        this(new KafkaProducer<>(config.toProducerProperties()), config);
    }

    TransformingAlarmKafkaMessageHandler(
            Producer<String, String> producer,
            KafkaConsumerConfig config
    ) {
        this.producer = Objects.requireNonNull(producer, "producer must not be null");
        this.config = Objects.requireNonNull(config, "config must not be null");
    }

    @Override
    public void handle(ConsumerRecord<String, String> record) throws ExecutionException, InterruptedException {
        LOGGER.info(() -> "Transformed alarm message"
                + " inputTopic=" + record.topic()
                + " outputTopic=" + config.outputTopic()
                + " partition=" + record.partition()
                + " offset=" + record.offset()
                + " key=" + record.key());

        String alarmJsonString = record.value();
        Map<String, Object> alarm = JsonStringParser.parseObjectFromString(alarmJsonString);
        AlarmSNMPTrap alarmSNMPTrap = new AlarmSNMPTrap(alarm);
        System.out.println("Alarm SNMP Trap: " + alarmSNMPTrap);
        ProducerRecord<String, String> outputRecord = new ProducerRecord<>(
                config.outputTopic(),
                record.key(),
                alarmJsonString
        );
        producer.send(outputRecord).get();
    }

    @Override
    public void close() {
        producer.close();
    }
}
