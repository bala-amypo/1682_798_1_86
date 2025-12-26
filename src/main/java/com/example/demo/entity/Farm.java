package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Double soilPH;
    
    @Column(nullable = false)
    private Double waterLevel;
    
    @Column(nullable = false)
    private String season;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;
    
    public Farm() {}
    
    public Farm(Long id, String name, Double soilPH, Double waterLevel, String season, User owner) {
        this.id = id;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
        this.owner = owner;
    }
    
    public static FarmBuilder builder() {
        return new FarmBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    
    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    
    public static class FarmBuilder {
        private Long id;
        private String name;
        private Double soilPH;
        private Double waterLevel;
        private String season;
        private User owner;
        
        public FarmBuilder id(Long id) { this.id = id; return this; }
        public FarmBuilder name(String name) { this.name = name; return this; }
        public FarmBuilder soilPH(Double soilPH) { this.soilPH = soilPH; return this; }
        public FarmBuilder waterLevel(Double waterLevel) { this.waterLevel = waterLevel; return this; }
        public FarmBuilder season(String season) { this.season = season; return this; }
        public FarmBuilder owner(User owner) { this.owner = owner; return this; }
        
        public Farm build() {
            return new Farm(id, name, soilPH, waterLevel, season, owner);
        }
    }
}