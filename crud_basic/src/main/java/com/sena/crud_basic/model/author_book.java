package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="author_book")
public class author_book {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_author_book")
    private int id_author_book;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_author")
    private int id_author;


}
