package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // --------------------- CROPS ---------------------

    @PostMapping("/crops")
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop savedCrop = catalogService.saveCrop(crop);
        return ResponseEntity.ok(savedCrop);
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> getSuitableCrops(@RequestParam String soilType) {
        List<Crop> crops = catalogService.getSuitableCrops(soilType);
        return ResponseEntity.ok(crops);
    }

    // --------------------- FERTILIZERS ---------------------

    @PostMapping("/fertilizers")
    public ResponseEntity<Fertilizer> createFertilizer(@RequestBody Fertilizer fertilizer) {
        Fertilizer savedFertilizer = catalogService.saveFertilizer(fertilizer);
        return ResponseEntity.ok(savedFertilizer);
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> getFertilizersByCrop(@RequestParam String cropName) {
        List<Fertilizer> fertilizers = catalogService.getFertilizersByCrop(cropName);
        return ResponseEntity.ok(fertilizers);
    }
}
