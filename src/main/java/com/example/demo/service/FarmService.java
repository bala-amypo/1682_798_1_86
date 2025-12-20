// // package com.example.demo.service;

// // import com.example.demo.entity.Farm;

// // import java.util.List;

// // public interface FarmService {

// //     Farm createFarm(Farm farm);

// //     List<Farm> getAll();

// //     Farm getById(Long id);
// // }

// package com.example.demo.service;

// import com.example.demo.entity.Farm;
// import java.util.List;

// public interface FarmService {
//     Farm createFarm(Farm farm, Long ownerId);
//     List<Farm> getFarmsByOwner(Long ownerId);
//     Farm getFarmById(Long farmId);
// }

package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));

        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10)
            throw new IllegalArgumentException("Invalid farm pH");

        if (!ValidationUtil.validSeason(farm.getSeason()))
            throw new IllegalArgumentException("Invalid season");

        farm.setOwner(owner);
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}
