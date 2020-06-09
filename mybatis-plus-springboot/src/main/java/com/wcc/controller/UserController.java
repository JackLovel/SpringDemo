package com.wcc.controller;

import com.wcc.dao.UserDao;
import com.wcc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public List<User> userList() {
        return userDao.selectList(null);
    }
}
