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

    // Get all crops
    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    // Find suitable crops based on soil type and nutrient levels
    @Override
    public List<Crop> findSuitableCrops(Double nitrogen, Double phosphorus, String soilType) {
        return cropRepository.findBySoilTypeAndNitrogenLessThanEqualAndPhosphorusLessThanEqual(
                soilType, nitrogen, phosphorus
        );
    }

    // Get all fertilizers
    @Override
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    // Find fertilizers for given crop names
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findByCropNameIn(cropNames);
    }
}
