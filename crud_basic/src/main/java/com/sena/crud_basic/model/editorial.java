package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;

@Entity(name="editorial")
public class editorial {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_editorial;

@Column(name="editorial", length = 20, nullable = false)
private String editorial;

@ManyToOne
@JoinColumn(name = "id_country")
private country id_country;
@Column(name="description", length = 20, nullable = false)
private String description;
public editorial(int id_editorial, String editorial, country id_country, String description){
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
