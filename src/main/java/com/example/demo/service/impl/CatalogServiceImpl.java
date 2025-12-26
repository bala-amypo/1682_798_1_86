package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer saveFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Fertilizer> getFertilizersByCrop(String cropName) {
        return fertilizerRepository.findByCropName(cropName);
    }

    @Override
    public List<Crop> getSuitableCrops(String soilType) {
        return cropRepository.findBySoilType(soilType);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double moisture, String soilType) {
        // Temporary dummy implementation; replace with actual logic
        return cropRepository.findBySoilType(soilType);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        // Temporary dummy implementation; replace with actual logic
        return fertilizerRepository.findAll();
    }
}
