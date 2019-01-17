package com.xxx.brixton.serverd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 在ribbon上使用Hystrix来实现断路的功能
 * 在Spring Cloud中使用了Hystrix 来实现断路器的功能。
 * Hystrix是Netflix开源的微服务框架套件之一，
 * 该框架目标在于通过控制那些访问远程系统、
 * 服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
 * Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，
 * 请求缓存和请求打包，以及监控和配置等功能。
 */
// @EnableCircuitBreaker开启断路器功能
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ServerDApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerDApplication.class);
    }
}
