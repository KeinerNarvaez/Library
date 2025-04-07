package com.sena.crud_basic.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.book;

public interface Ibook extends JpaRepository
<book,Integer>
{
    @Query("SELECT u FROM book u WHERE u.name_book LIKE %?1%")
    List<book> getListBookForName(String filter);
    @Query("SELECT u FROM book u WHERE  u.stars = ?1")
    List<book> getListBookForStars(int filter); 
}
