package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.DiningReview;

import java.util.List;

public interface DiningReviewService {
    DiningReview submitDiningReview(DiningReview diningReview);
    List<DiningReview> getPendingDiningReviews();
    boolean approveDiningReview(Long reviewId);
    boolean rejectDiningReview(Long reviewId);
    List<DiningReview> getApprovedDiningReviewsForRestaurant(Long restaurantId);
}