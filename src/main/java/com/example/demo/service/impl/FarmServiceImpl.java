// package com.example.demo.service.impl;

// import com.example.demo.entity.Farm;
// import com.example.demo.entity.User;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FarmRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.FarmService;
// import com.example.demo.util.ValidationUtil;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class FarmServiceImpl implements FarmService {

//     private final FarmRepository farmRepository;
//     private final UserRepository userRepository;

//     @Override
//     public Farm createFarm(Farm farm, Long ownerId) {
//         User user = userRepository.findById(ownerId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User"));

//         if (!ValidationUtil.validSeason(farm.getSeason())) {
//             throw new IllegalArgumentException("Invalid season");
//         }

//         farm.setOwner(user);
//         return farmRepository.save(farm);
//     }

//     @Override
//     public List<Farm> getFarmsByOwner(Long ownerId) {
//         User user = userRepository.findById(ownerId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User"));
//         return farmRepository.findByOwner(user);
//     }

//     @Override
//     public Farm getFarmById(Long farmId) {
//         return farmRepository.findById(farmId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Farm"));
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm createFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> getAll() {
        return farmRepository.findAll();
    }

    @Override
    public Farm getById(Long id) {
        return farmRepository.findById(id).orElseThrow();
    }
}
