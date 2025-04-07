package com.sena.crud_basic.DTO;


public class book_genreDTO {
    private int id_book_genre;
    private int id_genre;
    private int id_book;

    public book_genreDTO(int id_book_genre, int id_genre, int id_book) {
        this.id_book_genre = id_book_genre;
        this.id_genre = id_genre;
        this.id_book = id_book;
    }
    public void set_id_book_genre(int id_book_genre) {
        this.id_book_genre = id_book_genre;
    }
    public int get_id_book_genre() {
        return id_book_genre;
    }
    
    public void set_genre(int genre) {
        this.id_genre = genre;
    }
    public int get_id_genre(){
        return id_genre;
    }  
    public void set_id_book(int id_book) {
        this.id_book = id_book;
    }
    public int get_id_book() {
        return id_book;
    }

}
