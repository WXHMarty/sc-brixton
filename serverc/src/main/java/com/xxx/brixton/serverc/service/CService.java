package com.xxx.brixton.serverc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 注解@FeignClient直接将类注册到了bean容器当中
 */
@FeignClient("server-a")
public interface CService {

    @RequestMapping(value = "/server/a/add")
    String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
