package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.User;;

public interface UserService {

    User createUser(User user);

    User updateUserProfile(String displayName, User user);

    User getUserProfile(String displayName);

    boolean existsByDisplayName(String displayName);
}