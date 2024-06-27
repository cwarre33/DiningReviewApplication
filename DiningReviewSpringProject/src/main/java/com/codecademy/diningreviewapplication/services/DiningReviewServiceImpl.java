package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.DiningReview;
import com.codecademy.diningreviewapplication.models.ReviewStatus;
import com.codecademy.diningreviewapplication.repositories.DiningReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningReviewServiceImpl implements DiningReviewService {

    private final DiningReviewRepository diningReviewRepository;

    @Autowired
    public DiningReviewServiceImpl(DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }

    @Override
    public DiningReview submitDiningReview(DiningReview diningReview) {
        diningReview.setStatus(ReviewStatus.PENDING); // Initial status when submitted
        return diningReviewRepository.save(diningReview);
    }

    @Override
    public List<DiningReview> getPendingDiningReviews() {
        return diningReviewRepository.findByStatus(ReviewStatus.PENDING);
    }

    @Override
    public DiningReview approveDiningReview(Long reviewId) {
        DiningReview diningReview = diningReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Dining review not found: " + reviewId));

        diningReview.setStatus(ReviewStatus.ACCEPTED);
        return diningReviewRepository.save(diningReview);
    }

    @Override
    public DiningReview rejectDiningReview(Long reviewId) {
        DiningReview diningReview = diningReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Dining review not found: " + reviewId));

        diningReview.setStatus(ReviewStatus.REJECTED);
        return diningReviewRepository.save(diningReview);
    }

    @Override
    public List<DiningReview> getApprovedDiningReviewsForRestaurant(Long restaurantId) {
        return diningReviewRepository.findByRestaurantIdAndStatus(restaurantId, ReviewStatus.ACCEPTED);
    }
}