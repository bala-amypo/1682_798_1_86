package com.example.demo.repository;

import com.example.demo.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    @Query("SELECT s FROM Suggestion s WHERE s.farm.id = :farmId ORDER BY s.createdAt DESC")
    List<Suggestion> findByFarmId(@Param("farmId") Long farmId);
    
    Optional<Suggestion> findById(Long id);
}