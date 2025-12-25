package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.SuggestionService;
import com.example.demo.entity.Suggestion;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion getSuggestion(Long id) {
        return new Suggestion(); // dummy
    }

    @Override
    public Suggestion generateSuggestion(Long id) {
        return new Suggestion(); // dummy
    }
}
