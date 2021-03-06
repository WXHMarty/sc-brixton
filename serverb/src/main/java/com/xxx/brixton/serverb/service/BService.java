package com.xxx.brixton.serverb.service;

import com.alibaba.fastjson.JSONObject;
import com.xxx.brixton.common.constant.MessageData;
import com.xxx.brixton.common.entity.Entity;
import com.xxx.brixton.common.rocketmq.Producer;
import org.apache.log4j.Logger;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BService {

    private final Logger log = Logger.getLogger(BService.class);

    @Value("${servers.name.serverA}")
    private String serverA;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Producer producer;

    @Value("${rocket.topic}")
    private String mqTopic;

    @Value("${rocket.tags}")
    private String mqTags;

    public Map add(Integer a, Integer b) {
        String url = "http://" + serverA + "/server/a/add?a=" + a + "&b=" + b;
        String res = restTemplate.getForEntity(url, String.class).getBody();
        log.info("===========res is " + res);
        return JSONObject.parseObject(res).getInnerMap();
    }

    /**
     * 测试ribbon的getForEntity()方法
     * 使用url请求
     * @return
     */
    public Entity getForEntityByUrl() {
        String url = "http://" + serverA + "/server/a/rest-get-1?id={1}";
        ResponseEntity<Entity> responseEntity = restTemplate.getForEntity(url, Entity.class, "1");
        Entity entity = responseEntity.getBody();
        log.info(JSONObject.toJSONString(entity));
        return entity;
    }

    /**
     * 测试ribbon的getForEntity()方法
     * 使用uri请求
     * @return
     */
    public Entity getForEntityByUri() {
        String url = "http://" + serverA + "/server/a/rest-get-1?id={id}";
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(url).build().expand(1L).encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<Entity> responseEntity = restTemplate.getForEntity(uri, Entity.class);
        Entity entity = responseEntity.getBody();
        log.info(JSONObject.toJSONString(entity));
        return entity;
    }

    /**
     * 测试getForObject()方法
     * 和getForEntity()方法一样，有三种重载方法
     * @return
     */
    public Entity getForObject() {
        String url = "http://" + serverA + "/server/a/rest-get-1?id={1}";
        Entity entity = restTemplate.getForObject(url, Entity.class, "1");
        log.info(JSONObject.toJSONString(entity));
        return entity;
    }

    /**
     * 测试发送mq消息
     */
    public void sendDataToServerC() {
        for (int i=0; i<30; i++) {
            try {
                // 组织数据协议
                Map<String, String> map = new HashMap<>();
                map.put("asdf", ">>>>bhutyu:----> " + i);
                String json = MessageData.of(map).toJson();
                Message msg = new Message(mqTopic, Arrays.asList(mqTags.split(","))
                        .stream().collect(Collectors.joining(" || ")),
                        json.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult result = producer.send(msg);
                log.info("== " + result);
                Thread.sleep(500);
            } catch (Exception e) {
                log.error(e.getMessage());
                return;
            }
        }
    }
}
