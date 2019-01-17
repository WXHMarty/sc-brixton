package com.xxx.brixton.serverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用ribbon和eureka结合解决服务服务提供者的负载均衡
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBApplication.class);
    }
}
