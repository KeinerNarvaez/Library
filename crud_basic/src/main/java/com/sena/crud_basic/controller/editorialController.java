package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.editorialDTO;
import com.sena.crud_basic.service.editorialService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/editorial")
public class editorialController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private editorialService editorialService;

    @PostMapping("/")
    public ResponseEntity<Object> registereditorial(@RequestBody editorialDTO editorial) {
        editorialService.save(editorial);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}