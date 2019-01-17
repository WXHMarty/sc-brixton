package com.xxx.brixton.servere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 在Feign中使用Hystrix
 * Feign中已经集成了Hystrix
 * 不需要再导入Hystrix包
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServerEApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerEApplication.class);
    }
}
