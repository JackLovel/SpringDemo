package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUserList() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void edit(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }
}
