package com.xxx.brixton.common.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * rocketmq消费者工厂
 */
public class ConsumerFactory {

    private final Logger log = LoggerFactory.getLogger(ConsumerFactory.class);

    public DefaultMQPushConsumer init(String consumerGroup, String nameServerAddr, String topic, String... tags) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(nameServerAddr);
        String tag = tags.length == 0 ? "*" : Arrays.stream(tags).collect(Collectors.joining(" || "));
        try {
            consumer.subscribe(topic, tag);
        } catch (MQClientException e) {
            log.error(e.getErrorMessage());
            return null;
        }
        return consumer;
    }
}
