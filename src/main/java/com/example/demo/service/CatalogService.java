package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {
    List<Crop> getAllCrops();
    List<Fertilizer> getFertilizersByCrop(String cropName);
}
