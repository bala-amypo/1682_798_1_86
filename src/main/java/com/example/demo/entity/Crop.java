package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int suitablePHMin;
    private int suitablePHMax;
    private int requiredWater;
    private String season;

    // 🔹 getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuitablePHMin() {
        return suitablePHMin;
    }

    public void setSuitablePHMin(int suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public int getSuitablePHMax() {
        return suitablePHMax;
    }

    public void setSuitablePHMax(int suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public int getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(int requiredWater) {
        this.requiredWater = requiredWater;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
