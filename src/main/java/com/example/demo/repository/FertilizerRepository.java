package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // Use this method so your service code compiles
    List<Fertilizer> findByCropNameContaining(String cropName);

    // Optional: for multiple crops
    List<Fertilizer> findByCropNameIn(List<String> cropNames);
}
