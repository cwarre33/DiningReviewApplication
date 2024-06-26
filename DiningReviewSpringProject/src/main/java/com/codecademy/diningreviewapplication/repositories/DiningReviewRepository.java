package com.codecademy.diningreviewapplication.repositories;

import com.codecademy.diningreviewapplication.models.DiningReview;
import com.codecademy.diningreviewapplication.models.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {

    // Scenario 5: Submit dining review
    // Spring Data JPA handles basic CRUD operations

    // Scenario 6: Get pending dining reviews
    List<DiningReview> findByStatus(ReviewStatus status);

    // Scenario 7: Approve or reject dining review (update status)
    DiningReview findByIdAndStatus(Long id, ReviewStatus status);

    // Scenario 8: Fetch approved dining reviews for a restaurant
    List<DiningReview> findByRestaurantIdAndStatus(Long restaurantId, ReviewStatus status);

}