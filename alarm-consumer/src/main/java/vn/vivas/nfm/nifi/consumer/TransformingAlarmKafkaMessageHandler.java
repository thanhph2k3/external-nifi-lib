package vn.vivas.nfm.nifi.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vn.vivas.nfm.nifi.cache.RedisCacheService;
import vn.vivas.nfm.nifi.consumer.config.KafkaConsumerConfig;
import vn.vivas.nfm.nifi.model.*;
import vn.vivas.nfm.nifi.parser.JsonStringParser;
import vn.vivas.nfm.nifi.service.AlarmDecodeService;
import vn.vivas.nfm.nifi.service.AlarmRoutingService;
import vn.vivas.nfm.nifi.service.AlarmStandardizeService;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class TransformingAlarmKafkaMessageHandler implements AlarmMessageHandler, AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(TransformingAlarmKafkaMessageHandler.class.getName());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Producer<String, String> producer;
    private final KafkaConsumerConfig config;

    private final AlarmRoutingService alarmRoutingService;
    private final AlarmDecodeService alarmDecodeService;
    private final AlarmStandardizeService alarmStandardizeService;

    public TransformingAlarmKafkaMessageHandler(KafkaConsumerConfig config) {
        this(new KafkaProducer<>(config.toProducerProperties()), config);
    }

    TransformingAlarmKafkaMessageHandler(
            Producer<String, String> producer,
            KafkaConsumerConfig config
    ) {
        this.producer = Objects.requireNonNull(producer, "producer must not be null");
        this.config = Objects.requireNonNull(config, "config must not be null");
        this.alarmRoutingService = new AlarmRoutingService(new RedisCacheService("10.167.59.25", 6379, "CzXLB3aZTPxp"));
        this.alarmDecodeService = new AlarmDecodeService();
        this.alarmStandardizeService = new AlarmStandardizeService();
    }

    @Override
    public void handle(ConsumerRecord<String, String> record) throws ExecutionException, InterruptedException, IOException {
        LOGGER.info(() -> "Transformed alarm message"
                + " inputTopic=" + record.topic()
                + " outputTopic=" + config.outputTopic()
                + " partition=" + record.partition()
                + " offset=" + record.offset()
                + " key=" + record.key());

        Map<String, Object> alarmSNMPTrap = JsonStringParser.parseObjectFromString(record.value());
        AlarmSNMPTrap alarmSnmpTrap = new AlarmSNMPTrap(alarmSNMPTrap);
        AlarmSNMPWithRouting alarmSNMPWithRouting = alarmRoutingService.route(alarmSnmpTrap);
        DecodedAlarm decodedAlarm = alarmDecodeService.decode(alarmSNMPWithRouting);
        DecodedAlarmWithRouting decodedAlarmWithRouting = new DecodedAlarmWithRouting(decodedAlarm, alarmSNMPWithRouting.alarmEnrichment());
        StandardizedAlarm standardizedAlarm = alarmStandardizeService.standardize(decodedAlarmWithRouting);
        ProducerRecord<String, String> outputRecord = new ProducerRecord<>(
                config.outputTopic(),
                record.key(),
                standardizedAlarm.toJsonString()
        );
        producer.send(outputRecord).get();
    }

    @Override
    public void close() {
        producer.close();
    }
}
