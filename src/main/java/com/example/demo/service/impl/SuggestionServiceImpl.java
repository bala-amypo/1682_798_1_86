package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponse;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service  // <- Make sure this annotation is present
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final FarmRepository farmRepository;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository, FarmRepository farmRepository) {
        this.suggestionRepository = suggestionRepository;
        this.farmRepository = farmRepository;
    }

    @Override
    public SuggestionResponse generateSuggestion(Long farmId, SuggestionRequest request) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(() ->
            new RuntimeException("Farm not found with id " + farmId));

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops(request.getSuggestedCrops());
        suggestion.setSuggestedFertilizers(request.getSuggestedFertilizers());

        Suggestion saved = suggestionRepository.save(suggestion);

        return new SuggestionResponse(
            saved.getId(),
            saved.getFarm().getId(),
            saved.getSuggestedCrops(),
            saved.getSuggestedFertilizers(),
            saved.getCreatedAt()
        );
    }

    @Override
    public SuggestionResponse getSuggestion(Long id) {
        Suggestion suggestion = suggestionRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Suggestion not found with id " + id));

        return new SuggestionResponse(
            suggestion.getId(),
            suggestion.getFarm().getId(),
            suggestion.getSuggestedCrops(),
            suggestion.getSuggestedFertilizers(),
            suggestion.getCreatedAt()
        );
    }
}
