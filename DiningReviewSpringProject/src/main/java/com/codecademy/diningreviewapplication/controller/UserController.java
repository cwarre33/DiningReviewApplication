package com.codecademy.diningreviewapplication.controller;

import com.codecademy.diningreviewapplication.models.User;
import com.codecademy.diningreviewapplication.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/com/codecademy/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping("/{displayName}")
    public ResponseEntity<User> getUser(@PathVariable String displayName) {
        User user = userService.getUserProfile(displayName);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{displayName}")
    public ResponseEntity<User> updateUser(@PathVariable String displayName, @RequestBody User user) {
        User updatedUser = userService.updateUserProfile(displayName, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{displayName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String displayName) {
        userService.deleteUser(displayName);
        return ResponseEntity.noContent().build();
    }

    // Example of a validation scenario for a dining review backend process
    @GetMapping("/validate/{displayName}")
    public ResponseEntity<Boolean> validateUserExistence(@PathVariable String displayName) {
        boolean exists = userService.existsByDisplayName(displayName);
        return ResponseEntity.ok(exists);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}