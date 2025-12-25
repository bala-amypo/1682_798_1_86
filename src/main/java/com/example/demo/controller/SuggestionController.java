package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponseDTO;
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
    public ResponseEntity<SuggestionResponseDTO> generate(
            @PathVariable Long farmId,
            @RequestBody SuggestionRequest request) {

        return ResponseEntity.ok(
                suggestionService.generateSuggestion(farmId, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuggestionResponseDTO> getSuggestion(@PathVariable Long id) {
        return ResponseEntity.ok(
                suggestionService.getSuggestion(id)
        );
    }
}
