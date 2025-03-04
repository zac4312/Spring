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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> IdUsers(Long Id) {
        return userRepository.findById(Id);
    }
    
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }
    
    public User updateUser(Long Id, User updatedUser) {
    Optional<User> existingUser = userRepository.findById(Id);
    
    if (existingUser.isPresent()) {
        User user = existingUser.get();
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        return userRepository.save(user);
    } else {
        throw new RuntimeException("User not found");
    }
}

}
