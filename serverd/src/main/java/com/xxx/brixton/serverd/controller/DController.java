package com.xxx.brixton.serverd.controller;

import com.xxx.brixton.serverd.server.DService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/server/d")
public class DController {

    @Autowired
    private DService dService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map add(@RequestParam Integer a, @RequestParam Integer b) {
        Map res = dService.add(a, b);
        res.put("server", "d");
        return res;
    }
}
