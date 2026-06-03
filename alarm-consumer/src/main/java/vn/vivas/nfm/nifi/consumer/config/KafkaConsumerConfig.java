package vn.vivas.nfm.nifi.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Properties;

public class KafkaConsumerConfig {

    private static final String DEFAULT_BOOTSTRAP_SERVERS = "10.167.59.39:9092";
    private static final String DEFAULT_TOPIC = "nfm.alarm.data.source.stp";
    private static final String DEFAULT_OUTPUT_TOPIC = "nfm.alarm.data.sink.stp";
    private static final String DEFAULT_GROUP_ID = "alarm-consumer";
    private static final String DEFAULT_AUTO_OFFSET_RESET = "earliest";
    private static final int DEFAULT_MAX_POLL_RECORDS = 100;
    private static final long DEFAULT_POLL_TIMEOUT_MS = 1_000L;

    private final String bootstrapServers;
    private final String topic;
    private final String outputTopic;
    private final String groupId;
    private final String autoOffsetReset;
    private final int maxPollRecords;
    private final Duration pollTimeout;

    public KafkaConsumerConfig(
            String bootstrapServers,
            String topic,
            String outputTopic,
            String groupId,
            String autoOffsetReset,
            int maxPollRecords,
            Duration pollTimeout
    ) {
        this.bootstrapServers = bootstrapServers;
        this.topic = topic;
        this.outputTopic = outputTopic;
        this.groupId = groupId;
        this.autoOffsetReset = autoOffsetReset;
        this.maxPollRecords = maxPollRecords;
        this.pollTimeout = pollTimeout;
    }

    public static KafkaConsumerConfig fromEnvironment() {
        return new KafkaConsumerConfig(
                readConfig("alarm.kafka.bootstrap.servers", "ALARM_KAFKA_BOOTSTRAP_SERVERS", DEFAULT_BOOTSTRAP_SERVERS),
                readConfig("alarm.kafka.topic", "ALARM_KAFKA_TOPIC", DEFAULT_TOPIC),
                readConfig("alarm.kafka.output.topic", "ALARM_KAFKA_OUTPUT_TOPIC", DEFAULT_OUTPUT_TOPIC),
                readConfig("alarm.kafka.group.id", "ALARM_KAFKA_GROUP_ID", DEFAULT_GROUP_ID),
                readConfig("alarm.kafka.auto.offset.reset", "ALARM_KAFKA_AUTO_OFFSET_RESET", DEFAULT_AUTO_OFFSET_RESET),
                readIntConfig("alarm.kafka.max.poll.records", "ALARM_KAFKA_MAX_POLL_RECORDS", DEFAULT_MAX_POLL_RECORDS),
                Duration.ofMillis(readLongConfig("alarm.kafka.poll.timeout.ms", "ALARM_KAFKA_POLL_TIMEOUT_MS", DEFAULT_POLL_TIMEOUT_MS))
        );
    }

    public Properties toKafkaProperties() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Integer.toString(maxPollRecords));
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        return properties;
    }

    public Properties toProducerProperties() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        return properties;
    }

    public String topic() {
        return topic;
    }

    public String outputTopic() {
        return outputTopic;
    }

    public Duration pollTimeout() {
        return pollTimeout;
    }

    private static String readConfig(String propertyName, String environmentName, String defaultValue) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue != null && !propertyValue.isBlank()) {
            return propertyValue;
        }

        String environmentValue = System.getenv(environmentName);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue;
        }

        return defaultValue;
    }

    private static int readIntConfig(String propertyName, String environmentName, int defaultValue) {
        return Integer.parseInt(readConfig(propertyName, environmentName, Integer.toString(defaultValue)));
    }

    private static long readLongConfig(String propertyName, String environmentName, long defaultValue) {
        return Long.parseLong(readConfig(propertyName, environmentName, Long.toString(defaultValue)));
    }
}
