package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    // Make sure Fertilizer entity has a field `cropName`
    List<Fertilizer> findByCropName(String cropName);
}
