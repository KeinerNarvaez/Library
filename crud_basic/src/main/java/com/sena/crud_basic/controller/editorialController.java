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

import com.sena.crud_basic.DTO.editorialDTO;
import com.sena.crud_basic.DTO.responseDTO;
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
        responseDTO respuesta = editorialService.save(editorial);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
        @GetMapping("/{id}")
    public ResponseEntity<Object> getOneeditorial(@PathVariable int id) {
        var editorial = editorialService.findById(id);
        if (!editorial.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(editorial, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= editorialService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}