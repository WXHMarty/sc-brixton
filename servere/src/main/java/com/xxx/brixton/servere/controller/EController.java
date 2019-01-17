package com.xxx.brixton.servere.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxx.brixton.servere.service.EService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/server/e")
public class EController {

    private final Logger log = Logger.getLogger(EController.class);

    @Resource
    private EService eService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Map add(Integer a, Integer b) {
        String res = eService.add(a, b);
        log.info("== " + res);
        return JSONObject.parseObject(res).getInnerMap();
    }
}
