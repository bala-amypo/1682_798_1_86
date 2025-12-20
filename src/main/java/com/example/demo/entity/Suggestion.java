package com.example.demo.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="suggestions")
public class Suggestion{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="farm_id", nullable=false)
    private Farm farm;
    @Column(nullable=false,length=1000)
    private String suggestedCrops;
    @Column(nullable=false,length=1000)
    private String suggestedFertilizers;
    @Column(nullable=false,updatable=false)
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate() {
        this.createdAt=LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    public String getSuggestedCrops() {
        return suggestedCrops;
    }
    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }
    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }
    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    // public void setCreatedAt(LocalDateTime createdAt) {
    //     this.createdAt = createdAt;
    // }
    public Suggestion() {
    }
    public Suggestion( Farm farm, String suggestedCrops, String suggestedFertilizers) {
        this.farm = farm;
        this.suggestedCrops = suggestedCrops;
        this.suggestedFertilizers = suggestedFertilizers;
    }
    public Suggestion(Long id,Farm farm, String suggestedCrops,String suggestedFertilizers,LocalDateTime createdAt){
        this.id=id;
        this.farm=farm;
        this.suggestedCrops=suggestedCrops;
        this.suggestedFertilizers=suggestedFertilizers;
        this.createdAt=createdAt;
    }
    

}