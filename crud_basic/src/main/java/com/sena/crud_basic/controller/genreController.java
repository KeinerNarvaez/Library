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

import com.sena.crud_basic.DTO.genreDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.service.genreService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/genre")
public class genreController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private genreService genreService;

    @PostMapping("/")
    public ResponseEntity<Object> registergenre(@RequestBody genreDTO genre) {
        responseDTO respuesta = genreService.save(genre);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
            /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnegenre(@PathVariable int id) {
        var genre = genreService.findById(id);
        if (!genre.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletegenre(@PathVariable int id) {
        var message= genreService.deletegenre(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
