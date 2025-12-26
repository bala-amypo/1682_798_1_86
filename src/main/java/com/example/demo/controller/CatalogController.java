package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/farms")
    public ResponseEntity<?> getFarms() {
        try {
            List<Crop> crops = catalogService.getAllCrops();
            for (Crop crop : crops) {
                List<Fertilizer> ferts = catalogService.getFertilizersByCrop(crop.getName());
                crop.setFertilizers(ferts); // safely attach fertilizers
            }
            return ResponseEntity.ok(crops);
        } catch (Exception e) {
            e.printStackTrace(); // console will show full error if any
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
