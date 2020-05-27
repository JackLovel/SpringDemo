package com.example.demo.controller;

import com.example.demo.model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class ThymeleafController {
    @RequestMapping("/hi")
    public String hello(Locale locale, Model model) {
        model.addAttribute("greeting", "Hello!");
        model.addAttribute("title", "这是一个测试");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return "hello";
    }
}
