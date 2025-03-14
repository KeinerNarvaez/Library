package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.country;

public class editorialDTO {
private int id_editorial;
private String editorial;
private country id_country;
private String description;
public editorialDTO(int id_editorial, String editorial, country id_country, String description){
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
    public void set_id_country(country id_country) {
        this.id_country = id_country;
    }
    public country get_id_country(){
        return id_country;
    }
    public void set_description(String description) {
        this.description = description;
    }
    public String get_description(){
        return description;
    }
}
