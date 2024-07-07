package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model;

import jakarta.persistence.*;

@Entity
public class DisposalGuidelineClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the primary key generation strategy
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false) // Specifies the foreign key column for the association
    private WasteCategoryClass wasteCategoryClass;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for wasteCategoryClass
    public WasteCategoryClass getWasteCategoryClass() {
        return wasteCategoryClass;
    }

    // Setter for wasteCategoryClass
    public void setWasteCategoryClass(WasteCategoryClass wasteCategoryClass) {
        this.wasteCategoryClass = wasteCategoryClass;
    }
}
