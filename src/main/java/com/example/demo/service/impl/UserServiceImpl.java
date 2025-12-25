package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        // Dummy implementation
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // Dummy implementation
        return new User();
    }

    @Override
    public User findById(Long id) {
        // Dummy implementation
        return new User();
    }
}
