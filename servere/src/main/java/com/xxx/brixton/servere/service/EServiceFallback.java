package com.xxx.brixton.servere.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 回调实现类
 * 使用@Component注入到bean容器中
 */
@Component
public class EServiceFallback implements EService {

    private final Logger log = Logger.getLogger(EServiceFallback.class);

    @Override
    public String add(Integer a, Integer b) {
        Map m = new HashMap();
        m.put("error", true);
        log.warn(m);
        return JSONObject.toJSONString(m);
    }
}
