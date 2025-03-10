package com.sena.crud_basic.DTO;


public class authorDTO {

    private int id_author;

    private String author_name;

    private String biography;

    public authorDTO(int author, String author_name, String biography){
        this.id_author=author;
        this.author_name=author_name;
        this.biography=biography;
    }
    public void set_id_author(int id_author) {
        this.id_author = id_author;
    }
    public int get_id_author(){
        return id_author;
    }
    public void set_author_name(String author_name) {
        this.author_name = author_name;
    }
    public String get_author_name(){
        return author_name;
    }
    public void set_biography(String biography) {
        this.biography = biography;
    }
    public String get_biography(){
        return biography;
    }
}
