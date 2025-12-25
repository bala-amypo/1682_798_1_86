package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    private String suggestedCrops;
    private String suggestedFertilizers;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public String getSuggestedCrops() {
        return suggestedCrops;
    }

    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }

    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }

    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
