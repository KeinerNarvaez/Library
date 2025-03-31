package com.sena.crud_basic.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.user;

public interface Iuser extends JpaRepository
<user,Integer>
{

    @Query("SELECT u FROM user u WHERE u.status != false")
    List<user> getListUserActive();

    @Query("SELECT u FROM user u WHERE u.name LIKE %?1%")
    List<user> getListUserForName(String filter);
    


}