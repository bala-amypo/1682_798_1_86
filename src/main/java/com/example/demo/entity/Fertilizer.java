package com.example.demo.entity;

import java.util.regex.Pattern;

import org.apache.coyote.BadRequestException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fertilizers")
public class Fertilizer{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String npkRatio;

    @Column(nullable=false, length=1000)
    private String recommendedForCrops;


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
    public void setNpkRatio(String npkRatio) throws BadRequestException {
        if(npkRatio==null || !Pattern.matches("\\d=-\\d+-\\d+",npkRatio)) {
            throw new BadRequestException("Invalid NPK ratio format");
        }
        this.npkRatio=npkRatio;
    }
    public String getRecommendedForCrops() {
        return recommendedForCrops;
    }
    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }
    public Fertilizer() {
    }
    public Fertilizer(String name, String npkRatio, String recommendedForCrops) throws BadRequestException {
        this.name = name;
        setNpkRatio(npkRatio);
        this.recommendedForCrops = recommendedForCrops;
    }
    public Fertilizer(Long id, String name, String npkRatio, String recommendedForCrops) throws BadRequestException {
        this.id = id;
        this.name = name;
        setNpkRatio(npkRatio);
        this.recommendedForCrops = recommendedForCrops;
    }

    
}