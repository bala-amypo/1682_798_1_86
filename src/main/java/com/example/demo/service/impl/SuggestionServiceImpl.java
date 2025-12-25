package com.example.demo;

import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    // Constructor as expected by tests
    public SuggestionServiceImpl(FarmService farmService, CatalogService catalogService, SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion getSuggestion(Long farmId) {
        return new Suggestion();
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return new Suggestion();
    }
}
