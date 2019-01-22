package com.xxx.brixton.serverc.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxx.brixton.serverc.service.CService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/server/c")
public class CController {

    private final Logger log = Logger.getLogger(CController.class);

    @Autowired
    private CService cService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map add(@RequestParam Integer a, @RequestParam Integer b) {
        String res = cService.add(a, b);
        log.info(res);
        Map r = JSONObject.parseObject(res).getInnerMap();
        r.put("server", "c");
        return r;
    }
}
