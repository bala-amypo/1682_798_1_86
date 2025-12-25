package com.example.demo.dto;

import java.time.LocalDateTime;

public class SuggestionResponse {

    private Long id;
    private Long farmId;
    private String farmName;
    private String suggestedCrops;
    private String suggestedFertilizers;
    private LocalDateTime createdAt;

    public SuggestionResponse(
            Long id,
            Long farmId,
            String farmName,
            String suggestedCrops,
            String suggestedFertilizers,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.farmId = farmId;
        this.farmName = farmName;
        this.suggestedCrops = suggestedCrops;
        this.suggestedFertilizers = suggestedFertilizers;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getFarmId() {
        return farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getSuggestedCrops() {
        return suggestedCrops;
    }

    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
