package com.cc.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${user}") // git配置文件里的key
    String user = "111";

    @GetMapping(value = "/hi")
    public String hi(){
        return user;
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
