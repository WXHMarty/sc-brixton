package com.xxx.brixton.servere.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 在@FeignClient注解中使用fallback属性来定义出现异常的时候的熔断回调的类
 * 这个回调的类需要实现本接口
 * 而且实现类需要注册到bean容器当中
 */
@FeignClient(value = "server-a", fallback = EServiceFallback.class)
public interface EService {

    @RequestMapping(value = "/server/a/add", method = RequestMethod.GET)
    String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
