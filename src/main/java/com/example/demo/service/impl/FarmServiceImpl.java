package com.example.demo;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

import java.util.ArrayList;
import java.util.List;

public class FarmServiceImpl implements FarmService {

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        // Dummy implementation
        return farm;
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        // Dummy implementation
        return new ArrayList<>();
    }

    @Override
    public Farm getFarmById(Long id) {
        // Dummy implementation
        return new Farm();
    }
}
