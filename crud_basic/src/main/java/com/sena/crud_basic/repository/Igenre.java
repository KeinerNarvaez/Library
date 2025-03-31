package com.sena.crud_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.genre;
public interface Igenre extends JpaRepository 
<genre,Integer>
{
    @Query("SELECT u FROM genre u")
    List<genre> getListgenre();

    @Query("SELECT u FROM genre u WHERE u.genre LIKE %?1%")
    List<genre> getListgenreForName(String filter);
}
