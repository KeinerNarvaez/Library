package com.sena.crud_basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.user_rolDTO;

import com.sena.crud_basic.service.user_rolService;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/user_rol")
public class user_rolController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private user_rolService user_rolService;

    @PostMapping
    public ResponseEntity<Object> registerUser_rol(@RequestBody user_rolDTO user_rol) {
        responseDTO respuesta = user_rolService.save(user_rol);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneuser_rol(@PathVariable int id) {
        var user_rol = user_rolService.findById(id);
        if (!user_rol.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user_rol, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= user_rolService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}