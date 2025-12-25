package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;  // this must match the repository method

    // Getter and Setter
    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }
}
