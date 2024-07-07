package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.controller;

import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model.RecyclingTipClass;
import com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/") // Specify the base path for all endpoints in this controller
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService; // Injecting the RecyclingTipService dependency

    @GetMapping("/recycling-tips")
    public List<RecyclingTipClass> getAllRecyclingTip() {
        // Handles GET requests to /api/recycling-tips
        // Returns a list of all recycling tips
        return recyclingTipService.getAllRecyclingTip();
    }

    @GetMapping("/recycling-tips/{id}")
    public ResponseEntity<RecyclingTipClass> getAllRecyclingTipById(@PathVariable Long id) {
        // Handles GET requests to /api/recycling-tips/{id}
        // Returns a single recycling tip by its ID, or 404 if not found
        try {
            RecyclingTipClass recyclingTipClass = recyclingTipService.getAllRecyclingTipById(id);
            if (recyclingTipClass != null) {
                return ResponseEntity.ok(recyclingTipClass);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/recycling-tips")
    public ResponseEntity<RecyclingTipClass> createRecyclingTip(@Valid @RequestBody RecyclingTipClass recyclingTipClass) {
        // Handles POST requests to /api/recycling-tips
        // Creates a new recycling tip and returns it with a 201 status code
        try {
            RecyclingTipClass createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTipClass);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/recycling-tips/{id}")
    public ResponseEntity<RecyclingTipClass> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTipClass recyclingTipClass) {
        // Handles PUT requests to /api/recycling-tips/{id}
        // Updates an existing recycling tip by its ID, returns the updated tip or 404 if not found
        try {
            RecyclingTipClass updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTipClass);
            if (updatedRecyclingTip != null) {
                return ResponseEntity.ok(updatedRecyclingTip);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/recycling-tips/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        // Handles DELETE requests to /api/recycling-tips/{id}
        // Deletes the recycling tip by its ID and returns a 204 status code
        try {
            recyclingTipService.deleteRecyclingTip(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Extract field errors and format them into a more readable format
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce("", (acc, error) -> acc + error + "\n");

        // Create a response entity with a custom error message
        return ResponseEntity.badRequest().body(errorMessage);
    }

}