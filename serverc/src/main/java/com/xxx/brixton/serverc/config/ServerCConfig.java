package com.xxx.brixton.serverc.config;

import com.xxx.brixton.common.rocketmq.ConsumerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class ServerCConfig {

    @Bean // rockectmq消费者实例
    public ConsumerFactory consumerFactory() {
        return new ConsumerFactory();
    }
}
