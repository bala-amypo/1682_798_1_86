package com.example.demo.service;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.entity.Suggestion;

public interface SuggestionService {
    Suggestion generateSuggestion(Long farmId, SuggestionRequest request);
    Suggestion getSuggestion(Long suggestionId);
}
