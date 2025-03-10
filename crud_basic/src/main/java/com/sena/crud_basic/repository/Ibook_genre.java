package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crud_basic.model.book_genre;

public interface Ibook_genre extends JpaRepository
<book_genre,Integer>
{

}
