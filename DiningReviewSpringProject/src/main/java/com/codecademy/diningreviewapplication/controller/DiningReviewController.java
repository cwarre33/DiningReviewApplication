package com.codecademy.diningreviewapplication.controller;

import com.codecademy.diningreviewapplication.models.DiningReview;
import com.codecademy.diningreviewapplication.models.ReviewStatus;
import com.codecademy.diningreviewapplication.services.DiningReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com/codecademy/dining-reviews")
public class DiningReviewController {

    private final DiningReviewService diningReviewService;

    public DiningReviewController(DiningReviewService diningReviewService) {
        this.diningReviewService = diningReviewService;
    }

    @PostMapping
    public ResponseEntity<DiningReview> submitDiningReview(@RequestBody DiningReview diningReview) {
        DiningReview createdReview = diningReviewService.submitDiningReview(diningReview);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<DiningReview>> getPendingDiningReviews() {
        List<DiningReview> pendingReviews = diningReviewService.getPendingDiningReviews();
        return new ResponseEntity<>(pendingReviews, HttpStatus.OK);
    }

}