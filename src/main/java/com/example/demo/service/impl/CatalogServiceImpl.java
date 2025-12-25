package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.CatalogService;
import java.util.List;
import java.util.Collections;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<String> findFertilizersForCrops(List<String> crops) {
        // Dummy implementation for tests
        return Collections.emptyList();
    }
}
