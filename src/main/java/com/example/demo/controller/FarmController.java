package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    // Create a new farm
    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest request) {
        Farm farm = new Farm();
        farm.setName(request.getName());
        farm.setSoilPH(request.getSoilPH());
        farm.setWaterLevel(request.getWaterLevel());
        farm.setSeason(request.getSeason());

        return farmService.createFarm(farm, request.getOwnerId());
    }

    // Get a farm by its ID
    @GetMapping("/{id}")
    public Farm getFarm(@PathVariable Long id) {
        return farmService.getFarmById(id);
    }

    // Get all farms for a specific owner
    @GetMapping("/owner/{ownerId}")
    public List<Farm> getFarmsByOwner(@PathVariable Long ownerId) {
        return farmService.getFarmsByOwner(ownerId);
    }
}
