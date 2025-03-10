package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.book_genreDTO;
import com.sena.crud_basic.service.book_genreService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/book_genre")
public class book_genreController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private book_genreService book_genreService;

    @PostMapping("/")
    public ResponseEntity<Object> registerbook_genre(@RequestBody book_genreDTO book_genre) {
        book_genreService.save(book_genre);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}
