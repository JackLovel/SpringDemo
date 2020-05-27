package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("小明");
        user.setPassword("xxxx");
        return user;
    }
}
