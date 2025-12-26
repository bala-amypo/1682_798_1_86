package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String npkRatio;

    @Column(length = 500)
    private String recommendedForCrops;
}
