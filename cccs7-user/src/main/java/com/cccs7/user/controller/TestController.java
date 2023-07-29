package com.cccs7.user.controller;

import com.cccs7.redis.util.RedisShareLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String testSpringboot() {
        return "success";
    }

    @GetMapping("/testRedis")
    public void test() {
        redisTemplate.opsForValue().set("name", "cccs7");
    }

    @GetMapping("/testLock")
    public void testLock() {
        boolean res = redisShareLockUtil.lock("cccs7", "1111111", 100000L);
        System.out.println(res);
    }

    @GetMapping("/testLog")
    public void testLog() {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            log.info("这是{}条日志！", i);
        }
        long endTime = System.currentTimeMillis();
        log.info("当前耗时：{}", endTime - startTime);
    }
}
