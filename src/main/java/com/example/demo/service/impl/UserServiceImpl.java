package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Object findById(Long id) {
        // Dummy implementation for tests
        return null;
    }
}
