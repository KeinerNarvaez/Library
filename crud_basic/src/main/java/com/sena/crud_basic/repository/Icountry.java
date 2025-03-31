package com.sena.crud_basic.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.country;

public interface Icountry extends JpaRepository     
<country,Integer> 
    {
    @Query("SELECT u FROM country u")
    List<country> getListcountry();

    @Query("SELECT u FROM country u WHERE u.country LIKE %?1%")
    List<country> getListcountryForName(String filter);
    
    }


