package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponse;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;

import java.util.Optional;

public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final FarmRepository farmRepository;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository, FarmRepository farmRepository) {
        this.suggestionRepository = suggestionRepository;
        this.farmRepository = farmRepository;
    }

    @Override
    public SuggestionResponse generateSuggestion(Long farmId, SuggestionRequest request) {
        Optional<Farm> optionalFarm = farmRepository.findById(farmId);
        if (!optionalFarm.isPresent()) {
            throw new RuntimeException("Farm not found with id: " + farmId);
        }

        Farm farm = optionalFarm.get();

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops(request.getSuggestedCrops());
        suggestion.setSuggestedFertilizers(request.getSuggestedFertilizers());

        Suggestion savedSuggestion = suggestionRepository.save(suggestion);

        return new SuggestionResponse(
                savedSuggestion.getId(),
                farm.getId(),
                savedSuggestion.getSuggestedCrops(),
                savedSuggestion.getSuggestedFertilizers(),
                savedSuggestion.getCreatedAt()
        );
    }

    @Override
    public SuggestionResponse getSuggestion(Long id) {
        Optional<Suggestion> optionalSuggestion = suggestionRepository.findById(id);
        if (!optionalSuggestion.isPresent()) {
            throw new RuntimeException("Suggestion not found with id: " + id);
        }

        Suggestion suggestion = optionalSuggestion.get();
        return new SuggestionResponse(
                suggestion.getId(),
                suggestion.getFarm().getId(),
                suggestion.getSuggestedCrops(),
                suggestion.getSuggestedFertilizers(),
                suggestion.getCreatedAt()
        );
    }
}
