package com.example.demo.dto;

public class SuggestionRequest {
    private String suggestedCrops;
    private String suggestedFertilizers;

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
}
