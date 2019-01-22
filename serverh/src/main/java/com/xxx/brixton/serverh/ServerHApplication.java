package com.xxx.brixton.serverh;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul网关
 * Zuul网关作用：
 * 实现了路由功能来屏蔽诸多服务细节
 * 实现了服务级别、均衡负载的路由
 * 实现了接口权限校验与微服务业务逻辑的解耦
 * zuul还实现了断路器功能
 */
// @EnableZuulProxy开启Zuul服务网关功能
@EnableZuulProxy
// @SpringCloudApplication注解包含了@SpringBootApplication @EnableDiscoveryClient @EnableCircuitBreaker 三个注解
@SpringCloudApplication
public class ServerHApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHApplication.class);
    }
}
