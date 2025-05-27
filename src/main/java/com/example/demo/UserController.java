package com.example.demo;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author stude
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
     @GetMapping("/form")
    public String Display(){
    return "form";
    }
    
@PostMapping("/save")
public ResponseEntity<?> createUser(
        @RequestPart("user") UserDTO userDTO,
        @RequestPart("image") MultipartFile imageFile) {

    System.out.println("DTO Title: " + userDTO.getTitle());
    System.out.println("DTO Parag: " + userDTO.getParag());

    try {
        User savedUser = userService.createUser(userDTO, imageFile);
        return ResponseEntity.ok(savedUser);
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
    }
}

    @GetMapping
    public List<User> listUser(){
        return userService.listUsers();
    }
    
    @GetMapping("/{id}")
    public Optional<User> IdUser(@PathVariable Long id){
        return userService.IdUsers(id);
    }
    
    @DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return "User Deleted";
}

@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    Optional<User> existingUser = userService.IdUsers(id);
    if (existingUser.isPresent()) {
        User user = existingUser.get();
        user.setTitle(updatedUser.getTitle());
        user.setParag(updatedUser.getParag());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
