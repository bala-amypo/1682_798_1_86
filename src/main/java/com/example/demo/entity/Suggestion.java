package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "suggestions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;
    
    @Column(name = "suggested_crops", length = 2000)
    private String suggestedCrops;
    
    @Column(name = "suggested_fertilizers", length = 2000)
    private String suggestedFertilizers;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void prePersist() {
        createdAt = LocalDateTime.now();
    }
}