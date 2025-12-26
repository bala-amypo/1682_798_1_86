package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crops")
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop savedCrop = catalogService.saveCrop(crop);
        return ResponseEntity.ok(savedCrop);
    }
}
