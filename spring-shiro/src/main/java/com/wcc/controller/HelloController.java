package com.wcc.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/test")
    public String testPage() {
        return "test";
    }
    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }
    @RequestMapping("/update")
    public String update() {
        return "user/update";
    }
    @GetMapping("/toLogin")
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑处理
     */
    @PostMapping("/login")
    public String postLogin(String name, String password, Model model) {
        /**
         * 使用Shiro编写认证操作
         */
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        // 执行登录方法
        try {
            subject.login(token);
            // 登录成功
            // 跳转到test.html
            return "redirect:/test";
        } catch (UnknownAccountException e) {
            // 登录失败：用户名不存在
            model.addAttribute("msg", "用户名不存在!");
            return "login";
        } catch (IncorrectCredentialsException e) {
            // 登录失败：密码错误
            model.addAttribute("msg", "密码错误!");
            return "login";
        }
    }
}
