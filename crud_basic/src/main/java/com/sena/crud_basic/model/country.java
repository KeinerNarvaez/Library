package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity(name="country")
public class country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_country", nullable = false)
    private int id_country;
    
    @Column(name="country", length = 20, nullable = false)
    private String country;

    public country(int id_country, String country){
        this.id_country=id_country;
        this.country=country;
    }

    public country() {

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
