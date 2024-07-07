package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.controller;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.DisposalGuidelineClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Disposal-Guideline") // Specify the base path for all endpoints in this controller
@Validated
public class DisposalGuidelineController {

    @Autowired
    public DisposalGuidelineService disposalGuidelineService; // Injecting the DisposalGuidelineService dependency

    @GetMapping
    public List<DisposalGuidelineClass> getAllDisposalGuideline() {
        // Handles GET requests to /api/Disposal-Guideline
        // Returns a list of all disposal guidelines
        return disposalGuidelineService.getAllDisposalGuideline();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineClass> getAllDisposalGuidelineById(@PathVariable Long id) {
        // Handles GET requests to /api/Disposal-Guideline/{id}
        // Returns a single disposal guideline by its ID, or 404 if not found
        DisposalGuidelineClass disposalGuideline = disposalGuidelineService.getAllDisposalGuidelineById(id);
        if (disposalGuideline != null) {
            return ResponseEntity.ok(disposalGuideline);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelineClass> createDisposalGuideline(@Valid @RequestBody DisposalGuidelineClass disposalGuidelineClass) {
        // Handles POST requests to /api/Disposal-Guideline
        // Creates a new disposal guideline and returns it with a 201 status code
        DisposalGuidelineClass createdDisposalGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuidelineClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineClass> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelineClass disposalGuidelineClass) {
        // Handles PUT requests to /api/Disposal-Guideline/{id}
        // Updates an existing disposal guideline by its ID, returns the updated guideline or 404 if not found
        DisposalGuidelineClass updatedDisposal = disposalGuidelineService.updateDisposalGuideline(id, disposalGuidelineClass);
        if (updatedDisposal != null) {
            return ResponseEntity.ok(updatedDisposal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        // Handles DELETE requests to /api/Disposal-Guideline/{id}
        // Deletes the disposal guideline by its ID and returns a 204 status code
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }

}
