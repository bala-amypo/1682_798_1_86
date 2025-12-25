package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public String getSuggestion() {
        return "Default Suggestion";
    }

    // Add other methods as required by your SuggestionService interface
}
