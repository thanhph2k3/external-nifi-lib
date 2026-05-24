package vn.vivas.nfm.nifi.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

@FunctionalInterface
public interface AlarmMessageHandler {

    void handle(ConsumerRecord<String, String> record);
}
