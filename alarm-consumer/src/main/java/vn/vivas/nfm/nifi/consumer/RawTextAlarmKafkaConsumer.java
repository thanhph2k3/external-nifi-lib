package vn.vivas.nfm.nifi.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import vn.vivas.nfm.nifi.consumer.config.KafkaConsumerConfig;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class RawTextAlarmKafkaConsumer implements AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(RawTextAlarmKafkaConsumer.class.getName());

    private final KafkaConsumer<String, String> consumer;
    private final KafkaConsumerConfig config;
    private final AlarmMessageHandler messageHandler;
    private volatile boolean running = true;

    public RawTextAlarmKafkaConsumer(KafkaConsumerConfig config, AlarmMessageHandler messageHandler) {
        this(new KafkaConsumer<>(config.toKafkaProperties()), config, messageHandler);
    }

    RawTextAlarmKafkaConsumer(
            KafkaConsumer<String, String> consumer,
            KafkaConsumerConfig config,
            AlarmMessageHandler messageHandler
    ) {
        this.consumer = Objects.requireNonNull(consumer, "consumer must not be null");
        this.config = Objects.requireNonNull(config, "config must not be null");
        this.messageHandler = Objects.requireNonNull(messageHandler, "messageHandler must not be null");
    }

    public void start() {
        try {
            consumer.subscribe(List.of(config.topic()));
            LOGGER.info(() -> "Started raw-text alarm Kafka consumer topic=" + config.topic());

            while (running && !Thread.currentThread().isInterrupted()) {
                ConsumerRecords<String, String> records = consumer.poll(config.pollTimeout());
                for (ConsumerRecord<String, String> record : records) {
                    consumeRecord(record);
                }
            }
        } catch (WakeupException e) {
            if (running) {
                throw e;
            }
        } finally {
            close();
        }
    }

    public void stop() {
        running = false;
        consumer.wakeup();
    }

    @Override
    public void close() {
        consumer.close();
    }

    private void consumeRecord(ConsumerRecord<String, String> record) {
        try {
            messageHandler.handle(record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        commitRecord(record);
    }

    private void commitRecord(ConsumerRecord<String, String> record) {
        TopicPartition topicPartition = new TopicPartition(record.topic(), record.partition());
        OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(record.offset() + 1);
        consumer.commitSync(Map.of(topicPartition, offsetAndMetadata));
    }
}
