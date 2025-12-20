package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
@CrossOrigin
public class CatalogController {

    @Autowired
    private CatalogServiceImpl catalogService;

    // POST /catalog/crop – add crop (ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(
            @RequestBody CropRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                catalogService.addCrop(request)
        );
    }

    // POST /catalog/fertilizer – add fertilizer (ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(
            @RequestBody FertilizerRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                catalogService.addFertilizer(request)
        );
    }

    // GET /catalog/crops/suitable?ph=&water=&season=
    @GetMapping("/crops/suitable")
    public ResponseEntity<?> getSuitableCrops(
            @RequestParam double ph,
            @RequestParam String water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }

    // GET /catalog/fertilizers/by-crop?name=
    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<?> getFertilizersByCrop(
            @RequestParam String name) {

        return ResponseEntity.ok(
                catalogService.getFertilizersForCrop(name)
        );
    }
}
