package com.codecademy.diningreviewapplication.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dining_review")
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "peanut_score")
    private Integer peanutScore;

    @Column(name = "egg_score")
    private Integer eggScore;

    @Column(name = "dairy_score")
    private Integer dairyScore;

    @Column(name = "commentary", length = 1000)
    private String commentary;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReviewStatus status;

    // Constructors, getters, and setters

    public DiningReview() {
        // Default constructor
    }

    public DiningReview(Restaurant restaurant, User user, Integer peanutScore, Integer eggScore,
                        Integer dairyScore, String commentary, ReviewStatus status) {
        this.restaurant = restaurant;
        this.user = user;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
        this.status = status;
    }

    // Getters and setters
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