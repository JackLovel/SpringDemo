package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    @RequestMapping("/")
    public String index() {
        return "你好 Docker！";
    }
}
