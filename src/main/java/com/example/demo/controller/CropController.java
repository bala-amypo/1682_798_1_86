package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog/crops")
public class CropController {

    @PostMapping
    public ResponseEntity<String> createCrop(@RequestBody CropRequest request) {
        return ResponseEntity.ok("Crop created successfully");
    }
}
