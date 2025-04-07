package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
    /*
     *  
    */
@Entity(name="author")
public class author {

    /*
     * tributos o columnas de la entidad 
     * nullable es no nulo o nulo
     * @GeneratedValue(strategy = GenerationType.IDENTITY) es para auto incremental
    */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_author")
    private int id_author;
    
    @Column(name="author_name", length = 50, nullable = false)
    private String author_name;

    @Lob
    @Column(name="biography", length = 500, nullable = false)
    private String biography;
    @Lob
    @Column(name="image", nullable = false)
    private String image;

    @Column(name = "stars",length = 3, nullable = false)
    private String stars;

    @Column(name = "number_of_titles", nullable = false)
    private String number_of_titles;

    public author() {

    }
    public author(int author, String author_name, String biography, String image, String stars,String number_of_titles) {
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
