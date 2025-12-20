package com.example.demo.entity;
import org.apache.coyote.BadRequestException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="crops")

public class Crop{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private Double suitablePHMIN;
    @Column(nullable=false)
    private double suitablePHMAX;
    @Column(nullable=false)
    private Double requiredWater;
    @Column(nullable=false)
    private String season;
    
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
    public Double getSuitablePHMIN() {
        return suitablePHMIN;
    }
    public double getSuitablePHMAX() {
        return suitablePHMAX;
    }
    public void setSuitablePHRange(Double min, Double max) throws BadRequestException {
        if(min==null || max==null || min>max){
            throw new BadRequestException("PH min must be less than or equal to PH max");
        }
        this.suitablePHMIN=min;
        this.suitablePHMAX = max;
    }
    public Double getRequiredWater() {
        return requiredWater;
    }
    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) throws BadRequestException {
        if(season==null || 
        !(season.equalsIgnoreCase("Kharif")||
        season.equalsIgnoreCase("Rabi")||
        season.equalsIgnoreCase("Summer"))){
            throw new BadRequestException("Invalid season");
        }
        this.season = season;
    }
    public Crop() {
    }
    public Crop(Long id, String name, Double suitablePHMIN, double suitablePHMAX, Double requiredWater, String season) {
        this.id = id;
        this.name = name;
        this.suitablePHMIN = suitablePHMIN;
        this.suitablePHMAX = suitablePHMAX;
        this.requiredWater = requiredWater;
        this.season = season;
    }

    
}