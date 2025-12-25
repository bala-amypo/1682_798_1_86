package com.example.demo.dto;

import lombok.Data;

@Data
public class CropRequest {
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;
    
    public CropRequest() {}
    
    public CropRequest(String name, Double suitablePHMin, Double suitablePHMax, Double requiredWater, String season) {
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
        this.season = season;
    }
}