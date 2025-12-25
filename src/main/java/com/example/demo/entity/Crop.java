package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "crops")
public class Crop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double suitablePHMin;
    private Double suitablePHMax;

    private String season;

    // Default constructor
    public Crop() {}

    // Constructor with fields
    public Crop(String name, Double suitablePHMin, Double suitablePHMax, String season) {
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.season = season;
    }

    // Getters and Setters
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

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
