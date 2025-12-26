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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double suitablePHMin;

    @Column(nullable = false)
    private Double suitablePHMax;

    @Column(nullable = false)
    private Double requiredWater;

    @Column(nullable = false)
    private String season;
}
