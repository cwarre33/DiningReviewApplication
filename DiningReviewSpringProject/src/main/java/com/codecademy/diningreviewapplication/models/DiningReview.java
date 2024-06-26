package com.codecademy.diningreviewapplication.models;

import jakarta.persistence.*;

@Entity
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int rating; // 0-5 rating

    @Column(length = 5)
    private Integer peanutScore; // Optional peanut score (1-5)

    @Column(length = 5)
    private Integer eggScore; // Optional egg score (1-5)

    @Column(length = 5)
    private Integer dairyScore; // Optional dairy score (1-5)

    @Column(length = 500)
    private String commentary; // Optional commentary about the visit

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private ReviewStatus status; // Status of the dining review (PENDING, ACCEPTED, REJECTED)

    // Constructors, getters, and setters

    public DiningReview() {
        this.status = ReviewStatus.PENDING; // Default status when a review is created
    }

    public DiningReview(Restaurant restaurant, User user, int rating, Integer peanutScore, Integer eggScore, Integer dairyScore, String commentary) {
        this.restaurant = restaurant;
        this.user = user;
        this.rating = rating;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
        this.status = ReviewStatus.PENDING; // Default status when a review is created
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Integer getPeanutScore() {
        return peanutScore;
    }

    public void setPeanutScore(Integer peanutScore) {
        this.peanutScore = peanutScore;
    }

    public Integer getEggScore() {
        return eggScore;
    }

    public void setEggScore(Integer eggScore) {
        this.eggScore = eggScore;
    }

    public Integer getDairyScore() {
        return dairyScore;
    }

    public void setDairyScore(Integer dairyScore) {
        this.dairyScore = dairyScore;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public void setStatus(ReviewStatus status) {
        this.status = status;
    }
}