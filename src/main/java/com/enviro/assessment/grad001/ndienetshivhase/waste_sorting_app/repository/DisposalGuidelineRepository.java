package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.DisposalGuidelineClass;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for DisposalGuidelineClass
// Extends JpaRepository to provide CRUD operations
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuidelineClass, Long> {

}
