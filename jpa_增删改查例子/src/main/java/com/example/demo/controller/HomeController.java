package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("hello")
    public String hello(Model model, @RequestParam(value = "name", required = false,
            defaultValue = "world") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
