package com.example.demo.controller;

import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping("/{farmId}")
    public ResponseEntity<?> generateSuggestion(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                suggestionService.generateSuggestion(farmId)
        );
    }

    @GetMapping("/{suggestionId}")
    public ResponseEntity<?> getSuggestion(@PathVariable Long suggestionId) {
        return ResponseEntity.ok(
                suggestionService.getSuggestion(suggestionId)
        );
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<?> getSuggestionsByFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                suggestionService.getSuggestionsByFarm(farmId)
        );
    }
}
