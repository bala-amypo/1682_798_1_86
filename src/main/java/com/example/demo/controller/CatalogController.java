package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @PostMapping("/crops")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest request, Authentication authentication) {
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).body("Access denied");
        }
        
        Crop crop = Crop.builder()
                .name(request.getName())
                .suitablePHMin(request.getSuitablePHMin())
                .suitablePHMax(request.getSuitablePHMax())
                .season(request.getSeason())
                .requiredWater(request.getRequiredWater())
                .build();
        
        Crop saved = catalogService.addCrop(crop);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/fertilizers")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest request, Authentication authentication) {
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).body("Access denied");
        }
        
        Fertilizer fertilizer = Fertilizer.builder()
                .name(request.getName())
                .npkRatio(request.getNpkRatio())
                .recommendedForCrops(request.getRecommendedForCrops())
                .build();
        
        Fertilizer saved = catalogService.addFertilizer(fertilizer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> findCrops(
            @RequestParam double ph,
            @RequestParam double waterLevel,
            @RequestParam String season) {
        List<Crop> crops = catalogService.findSuitableCrops(ph, waterLevel, season);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/fertilizers")
    public ResponseEntity<List<Fertilizer>> findFerts(@RequestParam String crop) {
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(List.of(crop));
        return ResponseEntity.ok(fertilizers);
    }
}