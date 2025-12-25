package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SuggestionResponseDTO {

    private Long id;
    private Long farmId;
    private String farmName;

    private String suggestedCrops;
    private String suggestedFertilizers;

    private LocalDateTime createdAt;
}
