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

import com.sena.crud_basic.DTO.recovery_requestDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.service.recovery_requestService;


@RestController
@RequestMapping("/api/v1/recovery_request")
public class recovery_requestController {
  @Autowired
    private recovery_requestService recovery_requestService;

    @PostMapping("/")
    public ResponseEntity<Object> register(@RequestBody recovery_requestDTO recovery_request) {
        responseDTO respuesta = recovery_requestService.save(recovery_request);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        var lista = recovery_requestService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable int id) {
        var recovery_request = recovery_requestService.findById(id);
        if (!recovery_request.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(recovery_request, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message = recovery_requestService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<responseDTO> update(@PathVariable int id, @RequestBody recovery_requestDTO recovery_requestDTO) {
        responseDTO respuesta = recovery_requestService.update(id, recovery_requestDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}