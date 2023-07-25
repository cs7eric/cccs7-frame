package com.cccs7.mybatisplus.handler.config;

import com.cccs7.mybatisplus.handler.interceptor.SqlBeautyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public SqlBeautyInterceptor sqlBeautyInterceptor () {
        return new SqlBeautyInterceptor();
    }
}
