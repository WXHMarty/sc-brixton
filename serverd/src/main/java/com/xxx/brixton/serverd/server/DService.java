package com.xxx.brixton.serverd.server;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DService {

    private final Logger log = Logger.getLogger(DService.class);

    @Value("${servers.name.serverA}")
    private String serverA;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用其他服务的方法，
     * 使用@HystrixCommand 注解来指定当调用出现异常的时候执行回调的方法
     * @param a
     * @param b
     * @return
     */
    @HystrixCommand(fallbackMethod = "addFallback")
    public Map add(Integer a, Integer b) {
        String url = "http://" + serverA + "/server/a/add?a=" + a + "&b=" + b;
        String res = restTemplate.getForEntity(url, String.class).getBody();
        log.info(res);
        return JSONObject.parseObject(res).getInnerMap();
    }

    /**
     * 被上面的@HystrixCommand(fallbackMethod = "addFallback")
     * 指定为回调方法，当上述的调用方法出现异常的时候
     * 会执行此方法，返回m
     * @return
     */
    public Map addFallback(Integer a, Integer b) {
        Map m = new HashMap();
        m.put("error", true);
        log.warn(m);
        return m;
    }
}
