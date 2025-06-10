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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    
public User createUser(UserDTO userDTO, MultipartFile imageFile) throws IOException {
    String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

    String uploadDir = "src/main/resources/static/uploads/";

    Path uploadPath = Paths.get(uploadDir);
    if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
    }

    Path filePath = uploadPath.resolve(fileName);

    Files.write(filePath, imageFile.getBytes());

    User user = new User();
    user.setTitle(userDTO.getTitle());
    user.setParag(userDTO.getParag());
    user.setImage(fileName);  
    user.setMemories(userDTO.isMemories());
    user.setFood(userDTO.isFood());
    user.setMedia(userDTO.isMedia());
    user.setSport(userDTO.isSport());

    userRepository.save(user);

    return user;
}


    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> IdUsers(Long id) {
        return userRepository.findById(id);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }   
    
    public User updateUser(Long id, User updatedUser) {
    Optional<User> existingUser = userRepository.findById(id);
    
    if (existingUser.isPresent()) {
        User user = existingUser.get();
        user.setTitle(updatedUser.getTitle());
        user.setParag(updatedUser.getParag());
        user.setMemories(updatedUser.getMemories());
        user.setFood(updatedUser.getFood());
        user.setMedia(updatedUser.getMedia());
        user.setSport(updatedUser.getSport());
        return userRepository.save(user);
    } else {
        throw new RuntimeException("User not found");
    }
}

}
