package com.sena.crud_basic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name="book")
public class book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_book", nullable = false)
    private int id_book;
    
    @Column(name="name_book", length = 20, nullable = false)
    private String name_book;

    @Column(name="id_country", nullable = false)
    private int id_country;

    @Column(name="id_editorial", nullable = false)
    private int id_editorial;

    @Column(name="id_author_book", nullable = false)
    private int id_author_book;

    @Column(name="id_genre", nullable = false)
    private int id_genre;

    public book(int id_book, String name_book, int id_country, int id_editorial, int id_author_book, int id_genre){
        this.id_book=id_book;
        this.name_book=name_book;
        this.id_country=id_country;
        this.id_editorial=id_editorial;
        this.id_author_book=id_author_book;
        this.id_genre=id_genre;
    }
    public void set_id_book(int id_book) {
        this.id_book = id_book;
    }
    public int get_id_book(){
        return id_book;
    }
    public void set_name_book(String name_book) {
        this.name_book = name_book;
    }
    public String get_name_book(){
        return name_book;
    }
    public void set_id_country(int id_country) {
        this.id_country = id_country;
    }
    public int get_id_country(){
        return id_country;
    }
    public void set_id_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }
    public int get_id_editorial(){
        return id_editorial;
    }
    public void set_id_author_book(int id_author_book) {
        this.id_author_book = id_author_book;
    }
    public int get_id_author_book(){
        return id_author_book;
    }
    public void set_id_genre(int id_genre) {
        this.id_genre = id_genre;
    }
    public int get_id_genre(){
        return id_genre;
    }
}
