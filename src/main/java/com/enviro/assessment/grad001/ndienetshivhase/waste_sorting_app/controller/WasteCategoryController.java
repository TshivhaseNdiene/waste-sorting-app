package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.controller;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.WasteCategoryClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories") // Specify the base path for all endpoints in this controller
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service; // Injecting the WasteCategoryService dependency

    @GetMapping
    public List<WasteCategoryClass> getAllWasteCategories() {
        // Handles GET requests to /api/waste-categories
        // Returns a list of all waste categories
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryClass> getWasteCategoryById(@PathVariable Long id) {
        // Handles GET requests to /api/waste-categories/{id}
        // Returns a single waste category by its ID, or 404 if not found
        try {
            WasteCategoryClass categoryClass = service.getAllWasteCategoryById(id);
            if (categoryClass != null) {
                return ResponseEntity.ok(categoryClass);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategoryClass> createWasteCategory(@Valid @RequestBody WasteCategoryClass wasteCategoryClass) {
        // Handles POST requests to /api/waste-categories
        // Creates a new waste category and returns it with a 201 status code
        try {
            WasteCategoryClass createdCategory = service.createWasteCategory(wasteCategoryClass);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryClass> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategoryClass wasteCategoryClass) {
        // Handles PUT requests to /api/waste-categories/{id}
        // Updates an existing waste category by its ID, returns the updated category or 404 if not found
        try {
            WasteCategoryClass updatedCategory = service.updateWasteCategory(id, wasteCategoryClass);
            if (updatedCategory != null) {
                return ResponseEntity.ok(updatedCategory);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        // Handles DELETE requests to /api/waste-categories/{id}
        // Deletes the waste category by its ID and returns a 204 status code
        try {
            service.deleteWasteCategory(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
