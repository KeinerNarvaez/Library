package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crud_basic.model.editorial;

public interface Ieditorial extends JpaRepository
<editorial,Integer>
{

}
