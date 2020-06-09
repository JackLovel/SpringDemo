package com.wcc.service;

import com.wcc.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
