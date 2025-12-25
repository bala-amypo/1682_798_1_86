package com.example.demo.dto;

import lombok.Data;

@Data
public class SuggestionRequest {
    private String suggestedCrops;
    private String suggestedFertilizers;
}
