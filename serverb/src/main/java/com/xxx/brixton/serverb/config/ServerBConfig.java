package com.xxx.brixton.serverb.config;

import com.xxx.brixton.common.interceptor.ServerInterceptor;
import com.xxx.brixton.common.rocketmq.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ServerBConfig extends WebMvcConfigurerAdapter {

    @Value("${rocket.producerGroup}")
    private String producerGroup;

    @Value("${rocket.nameServerAddr}")
    private String nameServerAddr;

    /*
     * @LoadBalanced注解开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ServerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public Producer producer() {
        return new Producer(producerGroup, nameServerAddr);
    }
}
