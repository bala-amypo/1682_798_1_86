package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    // No-args constructor
    public Farm() {
    }

    // All-args constructor
    public Farm(Long id,
                User owner,
                String name,
                Double soilPH,
                Double waterLevel,
                String season) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Double getSoilPH() {
        return soilPH;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public String getSeason() {
        return season;
    }

    // Manual Builder (used in controllers)
    public static FarmBuilder builder() {
        return new FarmBuilder();
    }

    public static class FarmBuilder {

        private Long id;
        private User owner;
        private String name;
        private Double soilPH;
        private Double waterLevel;
        private String season;

        public FarmBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FarmBuilder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public FarmBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FarmBuilder soilPH(Double soilPH) {
            this.soilPH = soilPH;
            return this;
        }

        public FarmBuilder waterLevel(Double waterLevel) {
            this.waterLevel = waterLevel;
            return this;
        }

        public FarmBuilder season(String season) {
            this.season = season;
            return this;
        }

        public Farm build() {
            return new Farm(
                    id,
                    owner,
                    name,
                    soilPH,
                    waterLevel,
                    season
            );
        }
    }
}
    