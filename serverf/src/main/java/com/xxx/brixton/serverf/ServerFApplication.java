package com.xxx.brixton.serverf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务
 * 配置文件可以统一管理
 */
// @EnableConfigServer开启配置配置服务功能
@EnableConfigServer
@SpringBootApplication
public class ServerFApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerFApplication.class);
    }
}
