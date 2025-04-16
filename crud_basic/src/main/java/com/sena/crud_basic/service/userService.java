package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.userDTO;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.repository.Iuser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iuser data;

    public List<user> findAll() {

        // return data.findAll();
        return data.getListUserActive();

    }

    public List<user> getListUserForName(String email,String password) {
        return data.getListUserForName(email,password);
    }
    public List<user> getname(String Filter) {
        return data.getname(Filter);
    }

    public Optional<user> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteUser(int id) {
        Optional<user> user=findById(id);
        if (!user.isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK,
                    "The register does not exist");
            return respuesta;
        }
        user.get().setStatus(false);
        data.save(user.get());
        // data.deleteById(id);
        
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK,
                "Se eliminó correctamente");
        return respuesta;
    }

    // register and update
    public responseDTO save(userDTO userDTO) {
        // validación longitud del nombre
        if (userDTO.get_name().length() < 1 ||
                userDTO.get_name().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST,
                    "El nombre debe estar entre 1 y 50 caracteres");
            return respuesta;
        }
        // otras condiciones
        // n
        user userRegister = converToModel(userDTO);
        data.save(userRegister);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK,
                "Se guardó correctamente");
        return respuesta;
    }

    public userDTO convertToDTO(user user) {
        userDTO userdto = new userDTO(
                user.getId_user(),
                user.get_name(),
                user.getEmail(),
                user.get_password(),
                user.get_number(),
                user.get_registration_date(),
                user.getStatus()
                );
        return userdto;
    }

    public user converToModel(userDTO userDTO) {
        user user = new user(
                0,
                userDTO.get_name(),
                userDTO.getEmail(),
                userDTO.get_password(),
                userDTO.get_number(),
                LocalDateTime.now(),
                true);
        return user;
    }

}
