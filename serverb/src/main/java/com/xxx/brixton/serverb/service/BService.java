package com.xxx.brixton.serverb.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class BService {

    private final Logger log = Logger.getLogger(BService.class);

    @Value("${servers.name.serverA}")
    private String serverA;

    @Autowired
    private RestTemplate restTemplate;

    public Map add(Integer a, Integer b) {
        String url = "http://" + serverA + "/server/a/add?a=" + a + "&b=" + b;
        String res = restTemplate.getForEntity(url, String.class).getBody();
        log.info("===========res is " + res);
        return JSONObject.parseObject(res).getInnerMap();
    }
}
