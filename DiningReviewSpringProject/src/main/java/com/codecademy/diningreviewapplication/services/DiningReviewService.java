package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.DiningReview;

import java.util.List;

public interface DiningReviewService {
    DiningReview submitDiningReview(DiningReview diningReview);
    List<DiningReview> getPendingDiningReviews();
    DiningReview approveDiningReview(Long reviewId);
    DiningReview rejectDiningReview(Long reviewId);
    List<DiningReview> getApprovedDiningReviewsForRestaurant(Long restaurantId);
}