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
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public List<Crop> findSuitableCrops(Double nitrogen, Double phosphorus, String soilType) {
        return cropRepository.findBySoilTypeAndNitrogenLessThanEqualAndPhosphorusLessThanEqual(
                soilType, nitrogen, phosphorus
        );
    }

    @Override
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findByCropNameIn(cropNames);
    }

    // Implement missing method
    @Override
    public List<Fertilizer> getFertilizersByCrop(String cropName) {
        return fertilizerRepository.findByCropName(cropName);
    }
}
