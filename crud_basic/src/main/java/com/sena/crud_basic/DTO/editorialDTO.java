package com.sena.crud_basic.DTO;

public class editorialDTO {
private int id_editorial;
private String editorial;
private int id_country;
private String description;
public editorialDTO(int id_editorial, String editorial, int id_country, String description){
    this.id_editorial=id_editorial;
    this.editorial=editorial;
    this.id_country=id_country;
    this.description=description;
    }
    public void set_id_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }
    public int get_id_editorial(){
        return id_editorial;
    }
    public void set_editorial(String editorial) {
        this.editorial = editorial;
    }
    public String get_editorial(){
        return editorial;
    }
    public void set_id_country(int id_country) {
        this.id_country = id_country;
    }
    public int get_id_country(){
        return id_country;
    }
    public void set_description(String description) {
        this.description = description;
    }
    public String get_description(){
        return description;
    }
}
