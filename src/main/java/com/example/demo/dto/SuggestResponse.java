package com.example.demo.dto;

import java.time.LocalDateTime;

public class SuggestionResponseDTO {

    private Long suggestionId;
    private Long farmId;

    private String farmName;

    private String suggestedCrops;
    private String suggestedFertilizers;

    private LocalDateTime createdAt;

    // ✅ Constructors
    public SuggestionResponseDTO() {}

    public SuggestionResponseDTO(
            Long suggestionId,
            Long farmId,
            String farmName,
            String suggestedCrops,
            String suggestedFertilizers,
            LocalDateTime createdAt
    ) {
        this.suggestionId = suggestionId;
        this.farmId = farmId;
        this.farmName = farmName;
        this.suggestedCrops = suggestedCrops;
        this.suggestedFertilizers = suggestedFertilizers;
        this.createdAt = createdAt;
    }

    // ✅ Getters & Setters
    public Long getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getSuggestedCrops() {
        return suggestedCrops;
    }

    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }

    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }

    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
