package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.bookDTO;
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
        bookService.save(book);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}
