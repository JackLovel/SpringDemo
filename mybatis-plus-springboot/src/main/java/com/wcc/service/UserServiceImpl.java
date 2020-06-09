package com.wcc.service;

import com.wcc.dao.UserDao;
import com.wcc.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.selectList(null);
    }

    @Override
    public void save(User user) {
        userDao.update(user, null);
    }
}
