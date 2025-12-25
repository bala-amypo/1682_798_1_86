package com.example.demo;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion generateSuggestion(Long userId) {
        // Dummy implementation
        return new Suggestion();
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        // Dummy implementation
        return new Suggestion();
    }
}
