package com.sena.crud_basic.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.pageDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.service.pageService;

@RestController
@RequestMapping("/api/v1/page")
public class pageController {
 @Autowired
    private pageService pageService;

    @PostMapping("/")
    public ResponseEntity<Object> register(@RequestBody pageDTO page) {
        responseDTO respuesta = pageService.save(page);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        var lista = pageService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneauthor(@PathVariable int id) {
        var page = pageService.findById(id);
        if (!page.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= pageService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<responseDTO> updateEditorial(@PathVariable int id,@RequestBody pageDTO pageDTO) {
        responseDTO respuesta = pageService.update(id, pageDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}