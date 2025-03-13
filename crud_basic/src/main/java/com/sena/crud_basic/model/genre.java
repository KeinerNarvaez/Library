package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity(name="genre")
public class genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_genre", nullable = false)
    private int id_genre;
    
    @Column(name="genre", length = 20, nullable = false)
    private String genre;

    public genre(int id_genre, String genre){
        this.id_genre=id_genre;
        this.genre=genre;
    } 
    public genre(){
    }
    public void set_id_genre(int id_genre) {
        this.id_genre = id_genre;
    }
    public int get_id_genre(){
        return id_genre;
    }
    public void set_genre(String genre) {
        this.genre = genre;
    }
    public String get_genre(){
        return genre;
    }
}
