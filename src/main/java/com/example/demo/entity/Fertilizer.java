package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop; // <-- Add this

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNpkRatio() { return npkRatio; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }

    public Crop getCrop() { return crop; }  // <-- Add this
    public void setCrop(Crop crop) { this.crop = crop; } // <-- Add this
}
