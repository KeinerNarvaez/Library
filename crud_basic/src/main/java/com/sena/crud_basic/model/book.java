package com.sena.crud_basic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity(name="book")
public class book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_book", nullable = false)
    private int id_book;
    
    @Column(name="name_book", length = 20, nullable = false)
    private String name_book;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private country id_country;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private editorial id_editorial;

    @ManyToOne
    @JoinColumn(name = "id_author_book")
    private author id_author_book;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private book_genre id_book_genre;

    public book(int id_book, String name_book, country id_country, editorial id_editorial, author id_author_book, book_genre id_book_genre){
        this.id_book=id_book;
        this.name_book=name_book;
        this.id_country=id_country;
        this.id_editorial=id_editorial;
        this.id_author_book=id_author_book;
        this.id_book_genre=id_book_genre;
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
    public void set_id_country(country id_country) {
        this.id_country = id_country;
    }
    public country get_id_country(){
        return id_country;
    }
    public void set_id_editorial(editorial id_editorial) {
        this.id_editorial = id_editorial;
    }
    public editorial get_id_editorial(){
        return id_editorial;
    }
    public void set_id_author_book(author id_author_book) {
        this.id_author_book = id_author_book;
    }
    public author get_id_author_book(){
        return id_author_book;
    }
    public void set_id_book_genre(book_genre id_book_genre) {
        this.id_book_genre = id_book_genre;
    }
    public book_genre get_id_book_genre(){
        return id_book_genre;
    }
}
