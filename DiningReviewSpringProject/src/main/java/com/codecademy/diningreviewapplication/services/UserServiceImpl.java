package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.User;
import com.codecademy.diningreviewapplication.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserProfile(String displayName, User user) {
        User existingUser = userRepository.findByDisplayName(displayName);
        if (existingUser != null) {
            // Update fields that are allowed to be updated
            existingUser.setCity(user.getCity());
            existingUser.setState(user.getState());
            existingUser.setZipcode(user.getZipcode());
            existingUser.setInterestedInPeanutAllergies(user.isInterestedInPeanutAllergies());
            existingUser.setInterestedInEggAllergies(user.isInterestedInEggAllergies());
            existingUser.setInterestedInDairyAllergies(user.isInterestedInDairyAllergies());

            return userRepository.save(existingUser);
        } else {
            // Handle user not found error, throw exception or return null/empty user
            return null;
        }
    }

    @Override
    public User getUserProfile(String displayName) {
        return userRepository.findByDisplayName(displayName);
    }

    @Override
    public boolean existsByDisplayName(String displayName) {
        return userRepository.existsByDisplayName(displayName);
    }
}
