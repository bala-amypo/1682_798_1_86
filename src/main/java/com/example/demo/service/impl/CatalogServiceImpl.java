package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    // ✅ NO findBySuitableCropsIn() USED
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        List<Fertilizer> result = new ArrayList<>();

        for (Fertilizer fertilizer : fertilizerRepository.findAll()) {
            if (fertilizer.getSuitableCrops() != null) {
                for (String crop : fertilizer.getSuitableCrops()) {
                    if (cropNames.contains(crop)) {
                        result.add(fertilizer);
                        break;
                    }
                }
            }
        }
        return result;
    }

    // ✅ ONLY (soilPh, season) — rainfall IGNORED
    @Override
    public List<Crop> findSuitableCrops(Double soilPh,
                                        Double rainfall,
                                        String season) {
        return cropRepository.findSuitableCrops(soilPh, season);
    }
}
