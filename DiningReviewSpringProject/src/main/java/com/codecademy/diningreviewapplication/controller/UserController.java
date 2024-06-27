package com.codecademy.diningreviewapplication.controller;

import com.codecademy.diningreviewapplication.models.User;
import com.codecademy.diningreviewapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{displayName}")
    public ResponseEntity<User> updateUser(@PathVariable String displayName, @RequestBody User user) {
        User updatedUser = userService.updateUserProfile(displayName, user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{displayName}")
    public ResponseEntity<User> getUserByDisplayName(@PathVariable String displayName) {
        User user = userService.getUserProfile(displayName);
        return ResponseEntity.ok(user);
    }

    // Example of a validation scenario for a dining review backend process
    @GetMapping("/validate/{displayName}")
    public ResponseEntity<Boolean> validateUserExistence(@PathVariable String displayName) {
        boolean exists = userService.existsByDisplayName(displayName);
        return ResponseEntity.ok(exists);
    }
}