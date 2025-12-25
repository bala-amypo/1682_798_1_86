package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // For findCropByName
    Optional<Crop> findByName(String name);

    // For findSuitableCrops
    List<Crop> findBySuitablePHMinLessThanEqualAndSuitablePHMaxGreaterThanEqualAndSeason(Double minPH, Double maxPH, String season);
}
