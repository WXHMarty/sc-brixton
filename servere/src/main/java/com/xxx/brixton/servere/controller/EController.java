package com.xxx.brixton.servere.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxx.brixton.servere.service.EService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/server/e")
public class EController {

    private final Logger log = Logger.getLogger(EController.class);

    @Resource
    private EService eService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map add(@RequestParam Integer a, @RequestParam Integer b) {
        String res = eService.add(a, b);
        Map r = JSONObject.parseObject(res).getInnerMap();
        r.put("server", "e");
        log.info("== " + res);
        return JSONObject.parseObject(res).getInnerMap();
    }
}
