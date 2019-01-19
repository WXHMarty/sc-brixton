package com.xxx.brixton.serverg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 检测配置文文件服务
 * 从config-server中读取一些配置信息
 * 当远程的配置文件发生修改的时候
 * 不需要重启服务，只需要调用/refresh接口就能动态刷新配置文件
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServerGApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGApplication.class);
    }
}
