package com.example.demo.dto;

import lombok.Data;

@Data
public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
    
    public FertilizerRequest() {}
    
    public FertilizerRequest(String name, String npkRatio, String recommendedForCrops) {
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
    }
}