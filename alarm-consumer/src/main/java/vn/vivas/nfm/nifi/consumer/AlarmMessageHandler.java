package vn.vivas.nfm.nifi.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface AlarmMessageHandler {

    void handle(ConsumerRecord<String, String> record) throws ExecutionException, InterruptedException;
}
