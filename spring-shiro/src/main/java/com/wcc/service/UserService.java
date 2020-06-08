package com.wcc.service;

import com.wcc.domain.User;

public interface UserService {
    User findByName(String name);
    User findById(Integer id);
}
