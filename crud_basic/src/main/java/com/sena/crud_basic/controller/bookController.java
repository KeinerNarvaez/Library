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

import com.sena.crud_basic.DTO.bookDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.service.bookService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/book")
public class bookController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private bookService bookService;

    @PostMapping("/")
    public ResponseEntity<Object> registerbook(@RequestBody bookDTO book) {
        responseDTO respuesta = bookService.save(book);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllbook() {
        var lista = bookService.findAll();
        // List<user> listaUsuariO2= userService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

        @GetMapping("/{id}")
    public ResponseEntity<Object> getOnebook(@PathVariable int id) {
        var Book = bookService.findById(id);
        if (!Book.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= bookService.delete(id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
