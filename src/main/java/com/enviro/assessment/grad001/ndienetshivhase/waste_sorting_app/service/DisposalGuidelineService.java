package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.DisposalGuidelineClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository; // Injecting the DisposalGuidelineRepository dependency

    // Retrieves all disposal guidelines from the repository
    public List<DisposalGuidelineClass> getAllDisposalGuideline() {
        return disposalGuidelineRepository.findAll();
    }

    // Retrieves a single disposal guideline by its ID, or returns null if not found
    public DisposalGuidelineClass getAllDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id).orElse(null);
    }

    // Creates a new disposal guideline and saves it to the repository
    public DisposalGuidelineClass createDisposalGuideline(DisposalGuidelineClass disposalGuidelineClass) {
        return disposalGuidelineRepository.save(disposalGuidelineClass);
    }

    // Updates an existing disposal guideline by its ID, returns the updated guideline or null if not found
    public DisposalGuidelineClass updateDisposalGuideline(Long id, DisposalGuidelineClass disposalGuidelineClass) {
        if (disposalGuidelineRepository.existsById(id)) {
            disposalGuidelineClass.setId(id);
            return disposalGuidelineRepository.save(disposalGuidelineClass);
        }
        return null;
    }

    // Deletes a disposal guideline by its ID
    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
