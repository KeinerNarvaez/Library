package com.sena.crud_basic.DTO;

public class countryDTO {
    private int id_country;

    private String country;

    public countryDTO(int id_country, String country){
        this.id_country=id_country;
        this.country=country;
    }

    public void set_id_country(int id_country) {
        this.id_country = id_country;
    }
    public int get_id_country(){
        return id_country;
    }
    public void set_country(String country) {
        this.country = country;
    }
    public String get_country(){
        return country;
    } 
}
