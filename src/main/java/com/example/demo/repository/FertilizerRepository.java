package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // For single crop
    List<Fertilizer> findByCropName(String cropName);

    // For multiple crops
    List<Fertilizer> findByCropNameIn(List<String> cropNames);
}
