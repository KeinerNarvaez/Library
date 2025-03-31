package com.sena.crud_basic.DTO;

import jakarta.persistence.Lob;

public class bookDTO {

    private int id_book;
    

    private String name_book;
    @Lob
    private String image;


    private int id_country;


    private int id_editorial;

    private int id_author_book;


    public bookDTO(int id_book, String name_book,String image, int id_country, int id_editorial, int id_author_book) {
        this.id_book=id_book;
        this.name_book=name_book;
        this.image=image;
        this.id_country=id_country;
        this.id_editorial=id_editorial;
        this.id_author_book=id_author_book;
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
    public void set_image(String image) {
        this.image = image;
    }
    public String get_image(){
        return image;
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
}
