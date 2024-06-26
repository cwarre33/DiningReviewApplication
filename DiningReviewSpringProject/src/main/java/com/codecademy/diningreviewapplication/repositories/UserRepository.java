package com.codecademy.diningreviewapplication.repositories;

import com.codecademy.diningreviewapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Scenario 1: Create user profile with unique display name
    User findByDisplayName(String displayName);

    // Scenario 2: Update user profile (excluding displayName)
    User findByIdAndDisplayName(Long id, String displayName);

    // Scenario 3: Fetch user profile by display name
    User findByDisplayNameIgnoreCase(String displayName);

}