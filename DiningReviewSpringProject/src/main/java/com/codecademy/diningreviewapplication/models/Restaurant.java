package com.codecademy.diningreviewapplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;

    @Column(precision = 3, scale = 2)
    private BigDecimal peanutScore;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal eggScore;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal dairyScore;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal overallScore;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPeanutScore() {
        return peanutScore;
    }

    public void setPeanutScore(BigDecimal peanutScore) {
        this.peanutScore = peanutScore;
    }

    public BigDecimal getEggScore() {
        return eggScore;
    }

    public void setEggScore(BigDecimal eggScore) {
        this.eggScore = eggScore;
    }

    public BigDecimal getDairyScore() {
        return dairyScore;
    }

    public void setDairyScore(BigDecimal dairyScore) {
        this.dairyScore = dairyScore;
    }

    public BigDecimal getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(BigDecimal overallScore) {
        this.overallScore = overallScore;
    }
}

