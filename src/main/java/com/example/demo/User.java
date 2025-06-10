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

    @Column(length = 5000)
    private String parag;
    private String image;

    private boolean memories;
    private boolean sport;
    private boolean media;
    private boolean food;

        
    public User(){}

    public User(String title, String parag, String image, String genre, boolean memories, boolean sport, boolean media, boolean food){
        this.title = title;
        this.parag = parag;
        this.image = image;
        
        this.memories = memories;
        this.sport = sport;
        this.media = media;
        this.food = food;
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

///////////////////////////////////////////////////////////////////////////////////
 
    public boolean getMemories(){
        return memories;
    }public void setMemories(boolean memories) {this.memories = memories;}

    public boolean getSport(){
        return sport;
    }public void setSport(boolean sport) {this.sport = sport;}

    public boolean getMedia(){
        return media;
    }public void setMedia(boolean media) {this.media = media;}

    public boolean getFood(){
        return food;
    }public void setFood(boolean food) {this.food = food;}
}
