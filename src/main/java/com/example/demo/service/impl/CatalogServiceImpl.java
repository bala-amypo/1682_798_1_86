package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.CatalogService;
import com.example.demo.entity.Fertilizer;
import java.util.Collections;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return Collections.emptyList(); // dummy
    }

    @Override
    public List<String> findSuitableCrops(Double latitude, Double longitude, String soilType) {
        return Collections.emptyList(); // dummy
    }
}
