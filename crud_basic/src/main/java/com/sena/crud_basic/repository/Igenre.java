package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.genre;
public interface Igenre extends JpaRepository 
<genre,Integer>
{

}
