package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req,
                                     Authentication auth) {

        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();

        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req,
                                           Authentication auth) {

        Fertilizer fertilizer = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();

        return ResponseEntity.ok(
                catalogService.addFertilizer(fertilizer));
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> suitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season));
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> fertilizersByCrop(
            @RequestParam String name) {

        return ResponseEntity.ok(
                catalogService.findFertilizersForCrops(
                        List.of(name)));
    }
}
