package com.example.demo;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;

import java.util.ArrayList;
import java.util.List;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    // Constructor as expected by tests
    public FarmServiceImpl(FarmRepository farmRepository, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return new ArrayList<>();
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        return farm;
    }

    @Override
    public Farm getFarmById(Long id) {
        return new Farm();
    }
}
