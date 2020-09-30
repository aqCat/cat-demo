package com.example.catdemo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 第二种方式配置过滤器，第一种是使用@WebFilter注解，
 */
//@Configuration
public class CatFilterConfig {

    //@Bean
    public FilterRegistrationBean firstFilterRegistration() {
        //FilterRegistrationBean registration = new FilterRegistrationBean(new CatFilter());
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setName("catFilter");
        registration.setOrder(1); //可以设置顺序
        return registration;
    }
}
