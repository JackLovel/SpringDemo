package com.wcc.controller;

import com.wcc.mapper.UserMapper;
import com.wcc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControlller {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userlist")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    //    public User queryUserById(@PathVariable("id") int id) {
//        User user = userMapper.queryUserById(id);
//        return user;
//    }
    // 添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        User u = new User(3, "阿毛", "1212");
        userMapper.addUser(u);
        return "ok";
    }

    // 修改一个用户
    @GetMapping("/updateUser")
    public String updateUser() {
        User u = new User(3, "阿毛", "1213");
        userMapper.updateUser(u);
        return "ok";
    }

    // 根据id删除用户
    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(3);
        return "ok";
    }

}
