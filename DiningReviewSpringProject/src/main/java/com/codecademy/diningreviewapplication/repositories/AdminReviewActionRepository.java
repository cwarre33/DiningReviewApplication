package com.codecademy.diningreviewapplication.repositories;

import com.codecademy.diningreviewapplication.models.AdminReviewAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminReviewActionRepository extends JpaRepository<AdminReviewAction, Long> {
    // Define custom query methods if needed
}