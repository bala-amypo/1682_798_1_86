package com.example.demo.dto;

import lombok.Data;

@Data
public class FarmRequest {
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
    
    public FarmRequest() {}
    
    public FarmRequest(String name, Double soilPH, Double waterLevel, String season) {
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }
}