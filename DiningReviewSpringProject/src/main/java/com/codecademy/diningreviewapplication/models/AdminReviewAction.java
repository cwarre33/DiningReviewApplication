package com.codecademy.diningreviewapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminReviewAction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private boolean accept; // Flag indicating whether the admin accepts the dining review

    // Constructors, getters, and setters

    public AdminReviewAction() {
    }

    public AdminReviewAction(boolean accept) {
        this.accept = accept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}