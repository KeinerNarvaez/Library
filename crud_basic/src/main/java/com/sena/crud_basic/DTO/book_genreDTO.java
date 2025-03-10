package com.sena.crud_basic.DTO;
import com.sena.crud_basic.model.book;
import com.sena.crud_basic.model.genre;

public class book_genreDTO {
    private int id_book_genre;
    private genre genre;
    private book id_book;

    public book_genreDTO(int id_book_genre, com.sena.crud_basic.model.genre genre, book id_book) {
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
