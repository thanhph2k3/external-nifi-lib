package vn.vivas.nfm.nifi;

import vn.vivas.nfm.nifi.consumer.RawTextAlarmKafkaConsumer;
import vn.vivas.nfm.nifi.consumer.TransformingAlarmKafkaMessageHandler;
import vn.vivas.nfm.nifi.consumer.config.KafkaConsumerConfig;

public class Main {

    public static void main(String[] args) {
        KafkaConsumerConfig config = KafkaConsumerConfig.fromEnvironment();
        TransformingAlarmKafkaMessageHandler messageHandler = new TransformingAlarmKafkaMessageHandler(
                config
        );
        RawTextAlarmKafkaConsumer consumer = new RawTextAlarmKafkaConsumer(config, messageHandler);

        Runtime.getRuntime().addShutdownHook(new Thread(consumer::stop));
        try (messageHandler) {
            consumer.start();
        }
    }
}
