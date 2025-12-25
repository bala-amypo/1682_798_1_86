package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "crops")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(name = "suitable_ph_min")
    private Double suitablePHMin;
    
    @Column(name = "suitable_ph_max")
    private Double suitablePHMax;
    
    private String season;
    
    @Column(name = "required_water")
    private Double requiredWater;
    
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
    }
}