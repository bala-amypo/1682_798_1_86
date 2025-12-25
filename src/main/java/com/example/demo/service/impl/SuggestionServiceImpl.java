package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionRequest;
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
    public Suggestion generateSuggestion(Long farmId, SuggestionRequest request) {
        // Check if a suggestion already exists for this farm
        return suggestionRepository.findTopByFarmIdOrderByCreatedAtDesc(farmId)
                .orElseGet(() -> {
                    // Fetch farm
                    Farm farm = farmRepository.findById(farmId)
                            .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

                    // Create new suggestion with values from DTO
                    Suggestion suggestion = new Suggestion();
                    suggestion.setFarm(farm);
                    suggestion.setSuggestedCrops(request.getSuggestedCrops());
                    suggestion.setSuggestedFertilizers(request.getSuggestedFertilizers());

                    // Save and return
                    return suggestionRepository.save(suggestion);
                });
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
}
