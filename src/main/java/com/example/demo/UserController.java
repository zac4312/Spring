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

import java.util.List;
import java.util.Optional;
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
public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
}
    
    @GetMapping
    public List<User> listUser(){
        return userService.listUsers();
    }
    
    @GetMapping("/{Id}")
    public Optional<User> IdUser(@PathVariable Long Id){
        return userService.IdUsers(Id);
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
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
