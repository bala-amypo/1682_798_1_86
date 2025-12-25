package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return Collections.emptyList(); // dummy
    }

    @Override
    public List<Crop> findSuitableCrops(Double latitude, Double longitude, String soilType) {
        return Collections.emptyList(); // dummy
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return new Fertilizer(); // dummy
    }

    @Override
    public Crop addCrop(Crop crop) {
        return new Crop(); // dummy
    }
}
