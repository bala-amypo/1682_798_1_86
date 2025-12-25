package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponse;
import com.example.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/{farmId}")
    public ResponseEntity<SuggestionResponse> generate(
            @PathVariable Long farmId,
            @RequestBody SuggestionRequest request) {

        SuggestionResponse response = suggestionService.generateSuggestion(farmId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuggestionResponse> getSuggestion(@PathVariable Long id) {
        SuggestionResponse response = suggestionService.getSuggestion(id);
        return ResponseEntity.ok(response);
    }
}
