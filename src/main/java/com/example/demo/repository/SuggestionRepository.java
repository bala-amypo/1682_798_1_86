package com.example.demo.repository;

import com.example.demo.entity.Suggestion;
import com.example.demo.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    Optional<Suggestion> findTopByFarm_IdOrderByCreatedAtDesc(Long farmId);
}
