package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        return new User(); // dummy object for compilation
    }

    @Override
    public User findByEmail(String email) {
        return new User(); // dummy
    }

    @Override
    public User findById(Long id) {
        return new User(); // dummy
    }
}
