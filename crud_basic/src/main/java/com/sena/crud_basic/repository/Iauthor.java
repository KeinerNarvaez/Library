package com.sena.crud_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.author;
public interface Iauthor extends JpaRepository     
<author,Integer> 
    {
    @Query("SELECT u FROM author u")
    List<author> getListauthor();

    @Query("SELECT u FROM author u WHERE u.author_name LIKE %?1%")
    List<author> getListauthorForName(String filter);
    
    
    }

