package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant submitRestaurant(Restaurant restaurant);
    Restaurant findById(Long id);
    List<Restaurant> findAll();
    List<Restaurant> findByZipCodeAndAllergyScores(String zipCode, String allergy);
    Restaurant updateRestaurant(Long id, Restaurant restaurantDetails);
    Boolean deleteRestaurant(Long id);
    List<Restaurant> findByZipCode(String zipcode);
}