package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    // Optional: define custom query if you want
    List<Fertilizer> findByCropName(String cropName);
}
