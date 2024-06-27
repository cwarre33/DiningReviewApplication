package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.AdminReviewAction;
import com.codecademy.diningreviewapplication.repositories.AdminReviewActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminReviewActionServiceImpl implements AdminReviewActionService {

    private final AdminReviewActionRepository adminReviewActionRepository;

    @Autowired
    public AdminReviewActionServiceImpl(AdminReviewActionRepository adminReviewActionRepository) {
        this.adminReviewActionRepository = adminReviewActionRepository;
    }

    @Override
    public AdminReviewAction createAdminReviewAction(AdminReviewAction adminReviewAction) {
        return adminReviewActionRepository.save(adminReviewAction);
    }
}