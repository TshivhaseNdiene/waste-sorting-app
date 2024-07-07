package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.RecyclingTipClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for RecyclingTipClass
// Extends JpaRepository to provide CRUD operations
public interface RecyclingTipRepository extends JpaRepository<RecyclingTipClass, Long> {
}
