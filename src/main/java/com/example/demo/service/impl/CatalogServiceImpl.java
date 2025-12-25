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

    // ✅ Constructor REQUIRED by your test file
    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    // ✅ Add Crop
    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    // ✅ Add Fertilizer
    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    // ✅ Find fertilizers for given crop names
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findBySuitableCropsIn(cropNames);
    }

    // ✅ Find suitable crops
    @Override
    public List<Crop> findSuitableCrops(Double soilPh,
                                        Double rainfall,
                                        String season) {
        return cropRepository.findSuitableCrops(soilPh, rainfall, season);
    }
}
