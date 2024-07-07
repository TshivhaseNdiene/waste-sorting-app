package com.enviro.assessment.grad001.ndienetshivhase.waste_sorting_app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class WasteCategoryClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the primary key generation strategy
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true) // Specifies the relationship and cascade behavior
    private List<DisposalGuidelineClass> disposalGuidelineClasses;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true) // Specifies the relationship and cascade behavior
    private List<RecyclingTipClass> recyclingTipClasses;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for disposalGuidelineClasses
    public List<DisposalGuidelineClass> getDisposalGuidelineClasses() {
        return disposalGuidelineClasses;
    }

    // Setter for disposalGuidelineClasses
    public void setDisposalGuidelineClasses(List<DisposalGuidelineClass> disposalGuidelineClasses) {
        this.disposalGuidelineClasses = disposalGuidelineClasses;
    }

    // Getter for recyclingTipClasses
    public List<RecyclingTipClass> getRecyclingTipClasses() {
        return recyclingTipClasses;
    }

    // Setter for recyclingTipClasses
    public void setRecyclingTipClasses(List<RecyclingTipClass> recyclingTipClasses) {
        this.recyclingTipClasses = recyclingTipClasses;
    }
}
