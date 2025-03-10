package com.sena.crud_basic.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity(name = "book_genre")
public class book_genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_book_genre", nullable = false)
    private int id_book_genre;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private genre genre;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private book id_book;

    public book_genre(int id_book_genre, com.sena.crud_basic.model.genre genre, book id_book) {
        this.id_book_genre = id_book_genre;
        this.genre = genre;
        this.id_book = id_book;
    }
    public void set_id_book_genre(int id_book_genre) {
        this.id_book_genre = id_book_genre;
    }
    public int get_id_book_genre() {
        return id_book_genre;
    }
    
    public void set_genre(com.sena.crud_basic.model.genre genre) {
        this.genre = genre;
    }
    public genre get_id_genre(){
        return genre;
    }  
    public void set_id_book(book id_book) {
        this.id_book = id_book;
    }
    public book get_id_book() {
        return id_book;
    }


}
