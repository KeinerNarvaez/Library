package com.sena.crud_basic.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crud_basic.model.book;
public interface Ibook extends JpaRepository
<book,Integer>
{

}
