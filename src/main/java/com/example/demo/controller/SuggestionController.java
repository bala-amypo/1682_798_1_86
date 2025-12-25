package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping("/{farmId}")
    public ResponseEntity<Suggestion> generate(
            @PathVariable Long farmId,
            @RequestBody SuggestionRequest request) {
        
        Suggestion suggestion = suggestionService.generateSuggestion(farmId, request);
        return ResponseEntity.ok(suggestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suggestion> getSuggestion(@PathVariable Long id) {
        Suggestion suggestion = suggestionService.getSuggestion(id);
        return ResponseEntity.ok(suggestion);
    }
}
