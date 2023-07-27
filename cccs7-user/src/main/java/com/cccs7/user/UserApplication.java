package com.cccs7.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan(value = {"com.cccs7.*.mapper", "com.cccs7.*.dao"})
@ComponentScan(value = "com.cccs7")
@SpringBootApplication
@EnableWebMvc
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
