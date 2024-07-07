package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.RecyclingTipClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository; // Injecting the RecyclingTipRepository dependency

    // Retrieves all recycling tips from the repository
    public List<RecyclingTipClass> getAllRecyclingTip() {
        return recyclingTipRepository.findAll();
    }

    // Retrieves a single recycling tip by its ID, or returns null if not found
    public RecyclingTipClass getAllRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id).orElse(null);
    }

    // Creates a new recycling tip and saves it to the repository
    public RecyclingTipClass createRecyclingTip(RecyclingTipClass recyclingTipClass) {
        return recyclingTipRepository.save(recyclingTipClass);
    }

    // Updates an existing recycling tip by its ID, returns the updated tip or null if not found
    public RecyclingTipClass updateRecyclingTip(Long id, RecyclingTipClass recyclingTipClass) {
        if (recyclingTipRepository.existsById(id)) {
            recyclingTipClass.setId(id);
            return recyclingTipRepository.save(recyclingTipClass);
        }
        return null;
    }

    // Deletes a recycling tip by its ID
    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}
