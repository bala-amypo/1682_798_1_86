package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmRequest {
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
}
