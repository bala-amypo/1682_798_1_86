package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farms")
@CrossOrigin
public class FarmController {

    @Autowired
    private FarmServiceImpl farmService;

    // POST /farms – add farm
    @PostMapping
    public ResponseEntity<?> createFarm(
            @RequestBody FarmRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                farmService.createFarm(request, authentication.getName())
        );
    }

    // GET /farms – list farms of logged-in user
    @GetMapping
    public ResponseEntity<?> listFarms(Authentication authentication) {
        return ResponseEntity.ok(
                farmService.getFarmsByUser(authentication.getName())
        );
    }

    // GET /farms/{farmId} – get farm details
    @GetMapping("/{farmId}")
    public ResponseEntity<?> getFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                farmService.getFarmById(farmId)
        );
    }
}
