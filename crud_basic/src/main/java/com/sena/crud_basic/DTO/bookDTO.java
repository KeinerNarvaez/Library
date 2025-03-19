package com.sena.crud_basic.DTO;


public class bookDTO {

    private int id_book;
    

    private String name_book;


    private int id_country;


    private int id_editorial;

    private int id_author_book;


    private int id_book_genre;

    public bookDTO(int id_book, String name_book, int id_country, int id_editorial, int id_author_book, int id_book_genre){
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
    public void set_id_book_genre(int id_book_genre) {
        this.id_book_genre = id_book_genre;
    }
    public int get_id_book_genre(){
        return id_book_genre;
    }
}
