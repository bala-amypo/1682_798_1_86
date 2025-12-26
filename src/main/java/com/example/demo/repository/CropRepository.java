package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    // Find crops by soil type
    List<Crop> findBySoilType(String soilType);

    // Find crops by soil type and nutrient requirements
    List<Crop> findBySoilTypeAndNitrogenLessThanEqualAndPhosphorusLessThanEqual(
            String soilType, Double nitrogen, Double phosphorus
    );
}
