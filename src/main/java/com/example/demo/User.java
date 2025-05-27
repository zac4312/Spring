package com.example.demo;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stude
 */

import jakarta.persistence.*;

@Entity
@Table(name = "NB_database")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String parag;
    private String image;
        
    public User(){}

    public User(String title, String parag, String image){
        this.title = title;
        this.parag = parag;
        this.image = image;
    }
    
    public Long getId(){
        return id;
    } public void setId(Long id) {this.id = id;}

    public String getTitle(){
        return title;
    } public void setTitle(String title) {this.title = title;}

    
    public String getParag(){
        return parag;
    } public void setParag(String parag) {this.parag = parag;}

    public String getImage(){
        return image;
    } public void setImage(String image) {this.image = image;}

}
