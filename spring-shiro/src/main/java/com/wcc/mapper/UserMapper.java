package com.wcc.mapper;

import com.wcc.domain.User;

public interface UserMapper {
    User findByName(String name);
    User findById(Integer id);
}
