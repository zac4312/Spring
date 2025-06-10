package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Size;

public class UserDTO {

@JsonProperty("title")
private String title;

@JsonProperty("parag")
private String parag;

@JsonProperty("memories")
private boolean memories;

@JsonProperty("sport")
private boolean sport;

@JsonProperty("media")
private boolean media;

@JsonProperty("food")
private boolean food;

public String getTitle(){return title;}
public void setTitle(String title){this.title = title;}


@Size(max = 5000)
public String getParag(){return parag;}
public void setParag (String parag){this.parag = parag;}

    public boolean isMemories(){
        return memories;
    }public void setMemories(boolean memories) {this.memories = memories;}

    public boolean isSport(){
        return sport;
    }public void setSport(boolean sport) {this.sport = sport;}

    public boolean isMedia(){
        return media;
    }public void setMedia(boolean media) {this.media = media;}

    public boolean isFood(){
        return food;
    }public void setFood(boolean food) {this.food = food;}
}
