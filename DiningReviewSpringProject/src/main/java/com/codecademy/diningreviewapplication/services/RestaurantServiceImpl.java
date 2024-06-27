package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.Restaurant;
import com.codecademy.diningreviewapplication.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant submitRestaurant(Restaurant restaurant) {
        // Implement validation or business logic if needed
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found: " + id));
    }

    @Override
    public List<Restaurant> findByZipCodeAndAllergyScores(String zipCode, String allergy) {
        // Implement custom query logic in repository
        //return restaurantRepository.findByAddressAndReviews_User_AllergyScoreIsNotNullOrderByReviews_User_AllergyScoreDesc(zipCode);
        return null;
    }
}