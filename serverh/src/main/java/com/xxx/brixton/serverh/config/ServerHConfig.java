package com.xxx.brixton.serverh.config;

import com.xxx.brixton.serverh.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerHConfig {

    // 需要将过滤器实例化到bean容器
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
