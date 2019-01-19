package com.xxx.brixton.serverg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RefreshScope
@RestController
@RequestMapping("/server/g")
public class TestController {

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @RequestMapping(value = "/getAdmin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map getAdmin() {
        Map<String, String> adm = new HashMap<>();
        adm.put("username", username);
        adm.put("password", password);
        return adm;
    }
}
