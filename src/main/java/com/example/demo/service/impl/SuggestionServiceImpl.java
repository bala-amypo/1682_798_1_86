package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return new Suggestion(); // dummy
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return new Suggestion(); // dummy
    }
}
