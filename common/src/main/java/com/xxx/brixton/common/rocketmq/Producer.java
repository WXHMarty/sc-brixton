package com.xxx.brixton.common.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * rocketmq生产者
 */
public class Producer {

    private final Logger log = LoggerFactory.getLogger(Producer.class);

    // 生产者实例
    private DefaultMQProducer producer;

    /**
     * 初始化生产者实例
     * @param producerGroup
     * @param nameServerAddr
     * @return
     */
    public Producer(String producerGroup, String nameServerAddr) {
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameServerAddr);
        try {
            producer.start();
            log.info("producer is started !");
        } catch (MQClientException e) {
            log.error(e.getErrorMessage());
        }
    }

    /**
     * 生产者实例销毁
     */
    public void destory() {
        producer.shutdown();
    }

    /**
     * 发送消息
     * @param msg
     * @return SendResult
     * @throws Exception
     */
    public SendResult send(Message msg) throws Exception {
        return producer.send(msg);
    }
}
