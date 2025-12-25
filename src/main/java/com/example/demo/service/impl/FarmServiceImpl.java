package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        return new Farm(); // dummy
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return Collections.emptyList(); // dummy
    }

    @Override
    public Farm getFarmById(Long id) {
        return new Farm(); // dummy
    }
}
