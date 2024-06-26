package com.codecademy.diningreviewapplication.repositories;

import com.codecademy.diningreviewapplication.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // Scenario 9: Submit new restaurant entry (unique name and zip code)
    Restaurant findByNameAndZipcode(String name, String zipcode);

    // Scenario 10: Fetch restaurant details by ID
    Optional<Restaurant> findById(Long id);

    // Scenario 11: Fetch restaurants by zip code with user-submitted scores for a given allergy, sorted descending
    List<Restaurant> findByZipcodeAndDiningReviews_User_AllergyScoreIsNotNullOrderByDiningReviews_User_AllergyScoreDesc(String zipcode, String allergy);

}