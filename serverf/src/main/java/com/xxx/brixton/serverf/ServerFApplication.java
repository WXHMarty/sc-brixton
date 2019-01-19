package com.xxx.brixton.serverf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务
 * 配置文件可以通过配置服务统一管理
 * 可以和普通的服务提供端一样配置注册到eureka下
 */
// @EnableConfigServer开启配置配置服务功能
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ServerFApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerFApplication.class);
    }
}
