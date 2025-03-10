package com.sena.crud_basic.DTO;

public class genreDTO {
    private int id_genre;
    private String genre;

    public genreDTO(int id_genre, String genre){
        this.id_genre=id_genre;
        this.genre=genre;
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
