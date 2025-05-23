package com.sena.crud_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.author;
import com.sena.crud_basic.service.authorService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/author")
public class authorController {
    
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private authorService authorService;

    @PostMapping("/")
    public ResponseEntity<Object> registerauthor(@RequestBody authorDTO author) {
        responseDTO respuesta = authorService.save(author);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllauthor() {
        var lista = authorService.findAll();
        // List<user> listaUsuariO2= userService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneauthor(@PathVariable int id) {
        var author = authorService.findById(id);
        if (!author.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable int id) {
        var message= authorService.deleteAuthor(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
        @GetMapping("/Listauthor")
    public ResponseEntity<List<author>> getListauthor() {
        return ResponseEntity.ok(authorService.getListauthor());
    }
    @GetMapping("/filter/{filter}")
    public ResponseEntity<Object> getListauthorForName(@PathVariable String filter) {
        var authorList = authorService.getListauthorForName(filter);
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<responseDTO> updateAuthor(
            @PathVariable int id,
            @RequestBody authorDTO authorDTO) {
        
        responseDTO respuesta = authorService.update(id, authorDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}