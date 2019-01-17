package com.xxx.brixton.servera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class);
    }
}
