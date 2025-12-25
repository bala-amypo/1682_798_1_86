package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.FarmService;
import java.util.Collections;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Override
    public List<String> getFarmsByOwner(Long ownerId) {
        // Dummy implementation for tests
        return Collections.emptyList();
    }
}
