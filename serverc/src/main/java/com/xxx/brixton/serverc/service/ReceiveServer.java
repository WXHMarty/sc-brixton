package com.xxx.brixton.serverc.service;

import com.xxx.brixton.common.constant.MessageData;
import com.xxx.brixton.common.rocketmq.ConsumerFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 测试接收mq消息
 */
@Service
public class ReceiveServer {
    
    private final Logger log = LoggerFactory.getLogger(ReceiveServer.class);

    @Value("${rocket.consumerGroup}")
    private String consumerGroup;

    @Value("${rocket.nameServerAddr}")
    private String nameServerAddr;

    @Value("${rocket.topic}")
    private String mqTopic;

    @Value("${rocket.tags}")
    private String mqTags;

    @Autowired
    private ConsumerFactory consumerFactory;

    @PostConstruct
    public void receive() {
        DefaultMQPushConsumer consumer = consumerFactory.init(consumerGroup, nameServerAddr, mqTopic, mqTags);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
                log.info("================================");
                log.info(new String(list.get(0).getBody()));
                log.info("================================");

                // 向服务端返回消费成功结果
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        try {
            consumer.start();
            log.info("consumer is started !");
        } catch (MQClientException e) {
            log.error(e.getErrorMessage());
        }
    }
}
