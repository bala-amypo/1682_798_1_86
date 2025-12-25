package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "fertilizers")
public class Fertilizer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String npkRatio; // e.g., "10-10-10"

    private String crop; // Name of the crop this fertilizer is for

    // Default constructor
    public Fertilizer() {}

    // Constructor with fields
    public Fertilizer(String name, String npkRatio, String crop) {
        this.name = name;
        this.npkRatio = npkRatio;
        this.crop = crop;
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

    public String getNpkRatio() {
        return npkRatio;
    }

    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }
}
