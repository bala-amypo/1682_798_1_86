package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String soilType;

    @OneToMany(mappedBy = "cropName", fetch = FetchType.LAZY)
    private List<Fertilizer> fertilizers;

    public Crop() {}

    public Crop(String name, String soilType) {
        this.name = name;
        this.soilType = soilType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public List<Fertilizer> getFertilizers() { return fertilizers; }
    public void setFertilizers(List<Fertilizer> fertilizers) { this.fertilizers = fertilizers; }
}
     