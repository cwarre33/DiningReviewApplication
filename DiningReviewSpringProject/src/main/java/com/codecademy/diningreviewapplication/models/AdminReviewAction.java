package com.codecademy.diningreviewapplication.models;

public class AdminReviewAction {

    private boolean accept; // Flag indicating whether the admin accepts the dining review

    // Constructors, getters, and setters

    public AdminReviewAction() {
    }

    public AdminReviewAction(boolean accept) {
        this.accept = accept;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}