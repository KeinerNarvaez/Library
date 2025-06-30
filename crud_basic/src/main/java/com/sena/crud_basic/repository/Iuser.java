package com.sena.crud_basic.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.user;

public interface Iuser extends JpaRepository
<user,Integer>
{

    @Query("SELECT u FROM user u WHERE u.status != false")
    List<user> getListUserActive();

    @Query("SELECT u FROM user u WHERE u.email = ?1 AND u.password = ?2")
    List<user> getListUserForName(String email, String password);
    
    @Query("SELECT u FROM user u WHERE u.email like %?1%")
    List<user> getname(String Filter);

    @Query("SELECT u FROM user u WHERE u.id_user = ?1")
    List<user> getUserById(int id);
    
    Optional<user> findByEmail(String email);
    Optional<user> findByUsername(String name);



    List<user> findAllByStatus(boolean status);

}