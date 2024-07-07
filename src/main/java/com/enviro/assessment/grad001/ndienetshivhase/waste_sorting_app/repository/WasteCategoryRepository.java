package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.WasteCategoryClass;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for WasteCategoryClass
// Extends JpaRepository to provide CRUD operations
public interface WasteCategoryRepository extends JpaRepository<WasteCategoryClass, Long> {

}
