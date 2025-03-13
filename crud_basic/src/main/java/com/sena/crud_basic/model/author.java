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
   // constructor
    public author() {

    }
    public author(int author, String author_name, String biography){
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
