package com.example.demo.service;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponse;

public interface SuggestionService {

    SuggestionResponse generateSuggestion(Long farmId, SuggestionRequest request);

    SuggestionResponse getSuggestion(Long id);
}
