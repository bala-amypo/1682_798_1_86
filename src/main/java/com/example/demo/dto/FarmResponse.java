package com.example.demo.dto;

import lombok.Data;

@Data
public class FarmResponse {
    private Long id;
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
    private Long ownerId;
    private String ownerUsername;
    private String createdAt;
}
