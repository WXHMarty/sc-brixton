package com.xxx.brixton.servera.controller;

import com.xxx.brixton.common.entity.Entity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server/a")
public class ComputeController {

    private final Logger log = Logger.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        log.info("/add, host: " + instance.getHost() + ", service_id: " + instance.getServiceId() + ", result: " + r);
        Map res = new HashMap();
        res.put("r", r);
        return res;
    }

    /**
     * 测试getForEntity()方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/rest-get-1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Entity restGet(@RequestParam Long id) {
        log.info("params : " + id);
        Entity entity = new Entity();
        entity.setId(1L);
        entity.setFa("aaa");
        entity.setFb(10);
        entity.setFc(new Date());
        return entity;
    }
}
