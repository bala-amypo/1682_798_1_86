package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final FarmRepository farmRepository;

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return suggestionRepository.findFirstByFarmIdOrderByCreatedAtDesc(farmId)
                .orElseGet(() -> {
                    Farm farm = farmRepository.findById(farmId)
                            .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

                    Suggestion suggestion = new Suggestion();
                    suggestion.setFarm(farm);
                    suggestion.setSuggestedCrops("Crop1, Crop2"); // Replace with real logic
                    suggestion.setSuggestedFertilizers("Fertilizer1, Fertilizer2"); // Replace with real logic

                    return suggestionRepository.save(suggestion);
                });
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
}
