package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.dto.FarmResponse;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    // -------------------------
    // Create a new farm
    // -------------------------
    @PostMapping
    public FarmResponse createFarm(@RequestBody FarmRequest request) {
        Farm farm = new Farm();
        farm.setName(request.getName());
        farm.setSoilPH(request.getSoilPH());
        farm.setWaterLevel(request.getWaterLevel());
        farm.setSeason(request.getSeason());

        Farm savedFarm = farmService.createFarm(farm, request.getOwnerId());
        return mapToResponse(savedFarm);
    }

    // -------------------------
    // Get a farm by ID
    // -------------------------
    @GetMapping("/{id}")
    public FarmResponse getFarm(@PathVariable Long id) {
        Farm farm = farmService.getFarmById(id);
        return mapToResponse(farm);
    }

    // -------------------------
    // Get all farms by owner
    // -------------------------
    @GetMapping("/owner/{ownerId}")
    public List<FarmResponse> getFarmsByOwner(@PathVariable Long ownerId) {
        List<Farm> farms = farmService.getFarmsByOwner(ownerId);
        return farms.stream()
                    .map(this::mapToResponse)
                    .collect(Collectors.toList());
    }

    // -------------------------
    // Helper: Convert Farm entity to DTO
    // -------------------------
    private FarmResponse mapToResponse(Farm farm) {
        FarmResponse response = new FarmResponse();
        response.setId(farm.getId());
        response.setName(farm.getName());
        response.setSoilPH(farm.getSoilPH());
        response.setWaterLevel(farm.getWaterLevel());
        response.setSeason(farm.getSeason());
        response.setOwnerId(farm.getOwner().getId());
        response.setOwnerUsername(farm.getOwner().getName()); // <-- uses 'name' field from User
        response.setCreatedAt(farm.getCreatedAt().toString());
        return response;
    }
}
