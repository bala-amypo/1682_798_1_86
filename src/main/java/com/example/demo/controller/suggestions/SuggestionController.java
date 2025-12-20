package com.example.demo.controller;

import com.example.demo.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
@CrossOrigin
public class SuggestionController {

    @Autowired
    private SuggestionServiceImpl suggestionService;

    // POST /suggestions/{farmId} – generate suggestion
    @PostMapping("/{farmId}")
    public ResponseEntity<?> generateSuggestion(
            @PathVariable Long farmId,
            Authentication authentication) {

        return ResponseEntity.ok(
                suggestionService.generateSuggestion(farmId, authentication.getName())
        );
    }

    // GET /suggestions/{suggestionId}
    @GetMapping("/{suggestionId}")
    public ResponseEntity<?> getSuggestion(
            @PathVariable Long suggestionId) {

        return ResponseEntity.ok(
                suggestionService.getSuggestionById(suggestionId)
        );
    }

    // GET /suggestions/farm/{farmId}
    @GetMapping("/farm/{farmId}")
    public ResponseEntity<?> listFarmSuggestions(
            @PathVariable Long farmId) {

        return ResponseEntity.ok(
                suggestionService.getSuggestionsByFarm(farmId)
        );
    }
}
