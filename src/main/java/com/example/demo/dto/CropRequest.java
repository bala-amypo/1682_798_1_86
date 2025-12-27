package com.example.demo.dto;

public class CropRequest {

    private String cropName;
    private String season;
    private String soilType;
    private Double area;

    // No-args constructor
    public CropRequest() {
    }

    // Getters & Setters
    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
