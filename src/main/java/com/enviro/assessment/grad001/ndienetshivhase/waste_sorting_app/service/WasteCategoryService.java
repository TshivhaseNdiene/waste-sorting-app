package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.WasteCategoryClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository; // Injecting the WasteCategoryRepository dependency

    // Retrieves all waste categories from the repository
    public List<WasteCategoryClass> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    // Retrieves a single waste category by its ID, or returns null if not found
    public WasteCategoryClass getAllWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id).orElse(null);
    }

    // Creates a new waste category and saves it to the repository
    public WasteCategoryClass createWasteCategory(WasteCategoryClass wasteCategoryClass) {
        return wasteCategoryRepository.save(wasteCategoryClass);
    }

    // Updates an existing waste category by its ID, returns the updated category or null if not found
    public WasteCategoryClass updateWasteCategory(Long id, WasteCategoryClass wasteCategoryClass) {
        if (wasteCategoryRepository.existsById(id)) {
            wasteCategoryClass.setId(id);
            return wasteCategoryRepository.save(wasteCategoryClass);
        }
        return null;
    }

    // Deletes a waste category by its ID
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
