package com.cccs7.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String testSpringboot() {
        return "success";
    }

    @GetMapping("/testRedis")
    public void test(){
        redisTemplate.opsForValue().set("name", "cccs7");
    }
}
