package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Long id) {
        return new User(); // dummy for test
    }

    @Override
    public User findByEmail(String email) {
        return new User(); // dummy
    }

    @Override
    public User register(User user) {
        return new User(); // dummy
    }
}
