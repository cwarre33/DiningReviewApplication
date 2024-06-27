package com.codecademy.diningreviewapplication.controller;

import com.codecademy.diningreviewapplication.models.AdminReviewAction;
import com.codecademy.diningreviewapplication.models.DiningReview;
import com.codecademy.diningreviewapplication.services.DiningReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com/codecademy/admin")
public class AdminReviewActionController {

    private final DiningReviewService diningReviewService;

    public AdminReviewActionController(DiningReviewService diningReviewService) {
        this.diningReviewService = diningReviewService;
    }

    @GetMapping("/reviews/pending")
    public ResponseEntity<List<DiningReview>> getPendingReviews() {
        List<DiningReview> pendingReviews = diningReviewService.getPendingDiningReviews();
        return new ResponseEntity<>(pendingReviews, HttpStatus.OK);
    }

    @PostMapping("/reviews/{reviewId}/approve")
    public ResponseEntity<Void> approveReview(@PathVariable Long reviewId) {
        boolean approved = diningReviewService.approveDiningReview(reviewId);
        if (approved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Review approved successfully
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Review not found or already approved
        }
    }

    @PostMapping("/reviews/{reviewId}/disapprove")
    public ResponseEntity<Void> disapproveReview(@PathVariable Long reviewId) {
        boolean disapproved = diningReviewService.rejectDiningReview(reviewId);
        if (disapproved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Review disapproved successfully
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Review not found or already disapproved
        }
    }
}