package com.example.catdemo.controller;

import com.example.catdemo.entity.User;
import com.example.catdemo.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final User user;

    static {
        user = new User.UserBuilder().builderId(1).builderName("张三")
                .builderAge(23).builderSex(1).builderDescription("这个家伙有点懒").build();
    }

    @GetMapping("test")
    public String test() {
        return "测试";
    }

    @GetMapping("test1")
    public Result<User> test1() {
        return Result.success(user);
    }

}
