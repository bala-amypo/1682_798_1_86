package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // Custom query to find fertilizers whose recommendedForCrops string contains the crop name
    @Query("SELECT f FROM Fertilizer f WHERE f.recommendedForCrops LIKE %:cropName%")
    List<Fertilizer> findByRecommendedForCropsContaining(@Param("cropName") String cropName);
}
