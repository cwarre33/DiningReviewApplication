package com.codecademy.diningreviewapplication.services;

import com.codecademy.diningreviewapplication.models.User;
import com.codecademy.diningreviewapplication.repositories.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserProfile(String displayName) {
        return userRepository.findByDisplayName(displayName);
    }

    @Override
    @Transactional
    public User updateUserProfile(String displayName, User user) {
        User existingUser = userRepository.findByDisplayName(displayName);
        if (existingUser != null) {
            existingUser.setCity(user.getCity());
            existingUser.setState(user.getState());
            existingUser.setZipcode(user.getZipcode());
            existingUser.setInterestedInPeanutAllergies(user.isInterestedInPeanutAllergies());
            existingUser.setInterestedInEggAllergies(user.isInterestedInEggAllergies());
            existingUser.setInterestedInDairyAllergies(user.isInterestedInDairyAllergies());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(String displayName) {
        User user = userRepository.findByDisplayName(displayName);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public boolean existsByDisplayName(String displayName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByDisplayName'");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
