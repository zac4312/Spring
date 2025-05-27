package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

@JsonProperty("title")
private String title;

@JsonProperty("parag")
private String parag;

public String getTitle(){return title;}
public void setTitle(String title){this.title = title;}

public String getParag(){return parag;}
public void setParag (String parag){this.parag = parag;}
}
