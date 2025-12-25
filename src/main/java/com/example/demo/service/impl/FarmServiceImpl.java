package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {

    @Override
    public String getFarmName() {
        return "Default Farm";
    }

    // Add other methods as required by your FarmService interface
}
