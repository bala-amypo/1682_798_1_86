package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.Suggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {
    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        
        List<Crop> suitableCrops = catalogService.findSuitableCrops(
            farm.getSoilPH(), 
            farm.getWaterLevel(), 
            farm.getSeason()
        );
        
        List<String> cropNames = suitableCrops.stream()
                .map(Crop::getName)
                .collect(Collectors.toList());
        
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(cropNames);
        
        String suggestedCropsStr = cropNames.isEmpty() ? "No suitable crops found" : 
            cropNames.stream().collect(Collectors.joining(","));
        
        String suggestedFertilizersStr = fertilizers.isEmpty() ? "No fertilizers recommended" : 
            fertilizers.stream()
                .map(Fertilizer::getName)
                .collect(Collectors.joining(","));
        
        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(suggestedCropsStr)
                .suggestedFertilizers(suggestedFertilizersStr)
                .build();
        
        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found with id: " + suggestionId));
    }
}