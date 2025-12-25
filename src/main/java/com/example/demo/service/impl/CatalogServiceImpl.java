package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
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
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than PH max");
        }
        if (!List.of("Kharif", "Rabi", "Zaid").contains(crop.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fert) {
        if (!fert.getNpkRatio().matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("Invalid NPK ratio");
        }
        return fertilizerRepository.save(fert);
    }

    @Override
    public List<Crop> findSuitableCrops(Double soilPH, Double waterLevel, String season) {
        return cropRepository.findSuitableCrops(soilPH, season); // matches your test mocks
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return fertilizerRepository.findByCropNameIn(crops); // ensure repository method exists
    }
}
