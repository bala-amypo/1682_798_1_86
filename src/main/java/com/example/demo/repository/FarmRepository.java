package com.example.demo.repository;

import com.example.demo.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findByOwnerId(Long ownerId);
    
    @Query("SELECT f FROM Farm f WHERE f.owner.id = :ownerId")
    List<Farm> findAllByOwnerId(@Param("ownerId") Long ownerId);
}