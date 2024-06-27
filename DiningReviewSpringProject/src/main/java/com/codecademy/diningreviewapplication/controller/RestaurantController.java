package com.codecademy.diningreviewapplication.controller;

import com.codecademy.diningreviewapplication.models.Restaurant;
import com.codecademy.diningreviewapplication.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com/codecademy/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> submitRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.submitRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.findById(id);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(
            @RequestParam String zipcode, 
            @RequestParam String allergy) {
        List<Restaurant> restaurants = restaurantService.findByZipCodeAndAllergyScores(zipcode, allergy);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
}