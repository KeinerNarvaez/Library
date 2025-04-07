package com.sena.crud_basic.DTO;
import jakarta.persistence.Lob;

public class authorDTO {

    private int id_author;

    private String author_name;

    private String biography;
    @Lob
    private String image;
    private String stars;
    private String number_of_titles;
    public authorDTO(int author, String author_name, String biography,String image, String stars,String number_of_titles) {
        this.id_author=author;
        this.author_name=author_name;
        this.biography=biography;
        this.image=image;
        this.stars=stars;
        this.number_of_titles=number_of_titles;
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
    public void set_image(String image) {
        this.image = image;
    }
    public String get_image(){
        return image;
    }
    public void set_stars(String stars) {
        this.stars = stars;
    }
    public String get_stars(){
        return stars;
    }
    public void set_number_of_titles(String number_of_titles) {
        this.number_of_titles = number_of_titles;
    }
    public String get_number_of_titles(){
        return number_of_titles;
    }

}
