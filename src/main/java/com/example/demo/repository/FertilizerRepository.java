package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // Finds fertilizers for a given crop name (case-insensitive, works with CSV recommendedForCrops)
    @Query("SELECT f FROM Fertilizer f WHERE LOWER(f.recommendedForCrops) LIKE LOWER(CONCAT('%', :cropName, '%'))")
    List<Fertilizer> findByCropName(@Param("cropName") String cropName);
}
