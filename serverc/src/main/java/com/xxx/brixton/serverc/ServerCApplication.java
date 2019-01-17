package com.xxx.brixton.serverc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一个声明式的java客户端，它具备可插拔的注解支持
 * spring cloud为Feign增加了spring mvc的注解支持
 * 还整合了ribbon和eureka来提供负载均衡的http客户端实现
 */
// 开启feign功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServerCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerCApplication.class);
    }
}
