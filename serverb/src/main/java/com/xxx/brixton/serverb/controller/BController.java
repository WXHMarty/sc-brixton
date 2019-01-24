package com.xxx.brixton.serverb.controller;

import com.xxx.brixton.common.constant.Response;
import com.xxx.brixton.common.entity.Entity;
import com.xxx.brixton.serverb.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server/b")
public class BController {

    @Autowired
    private BService bService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Map> add(@RequestParam Integer a, @RequestParam Integer b) {
        Map r = bService.add(a, b);
        r.put("server", "b");
        return Response.success(r);
    }

    /**
     * 测试ribbon的getForEntity()方法
     * 使用url请求
     * @return
     */
    @RequestMapping(value = "/rest-get-1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Entity> restGet1() {
        return Response.success(bService.getForEntityByUrl());
    }

    /**
     * 测试ribbon的getForEntity()方法
     * 使用uri请求
     * @return
     */
    @RequestMapping(value = "/rest-get-2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Entity> restGet2() {
        return Response.success(bService.getForEntityByUri());
    }

    /**
     * 测试ribbon的getForObject()方法
     * @return
     */
    @RequestMapping(value = "/rest-get-3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Entity> restGet3() {
        return Response.success(bService.getForObject());
    }
}
