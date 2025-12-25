package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionRequest;
import com.example.demo.dto.SuggestionResponseDTO;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final FarmRepository farmRepository;

    public SuggestionServiceImpl(
            SuggestionRepository suggestionRepository,
            FarmRepository farmRepository
    ) {
        this.suggestionRepository = suggestionRepository;
        this.farmRepository = farmRepository;
    }

    @Override
    @Transactional
    public SuggestionResponseDTO generateSuggestion(Long farmId, SuggestionRequest request) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops(request.getSuggestedCrops());
        suggestion.setSuggestedFertilizers(request.getSuggestedFertilizers());

        Suggestion saved = suggestionRepository.save(suggestion);

        return new SuggestionResponseDTO(
                saved.getId(),
                farm.getId(),
                farm.getName(),
                saved.getSuggestedCrops(),
                saved.getSuggestedFertilizers(),
                saved.getCreatedAt()
        );
    }

    @Override
    public SuggestionResponseDTO getSuggestion(Long id) {

        Suggestion suggestion = suggestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));

        return new SuggestionResponseDTO(
                suggestion.getId(),
                suggestion.getFarm().getId(),
                suggestion.getFarm().getName(),
                suggestion.getSuggestedCrops(),
                suggestion.getSuggestedFertilizers(),
                suggestion.getCreatedAt()
        );
    }
}
