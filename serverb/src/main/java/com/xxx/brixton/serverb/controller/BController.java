package com.xxx.brixton.serverb.controller;

import com.xxx.brixton.serverb.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Map add(Integer a, Integer b) {
        Map r = bService.add(a, b);
        return r;
    }
}
