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

import com.sena.crud_basic.DTO.permission_roleDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.service.permission_roleService;

@RestController
@RequestMapping("/api/v1/permission_role")
public class permission_roleController {
  @Autowired
    private permission_roleService permission_roleService;

    @PostMapping("/")
    public ResponseEntity<Object> register(@RequestBody permission_roleDTO permission_role) {
        responseDTO respuesta = permission_roleService.save(permission_role);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        var lista = permission_roleService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable int id) {
        var permission_role = permission_roleService.findById(id);
        if (!permission_role.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(permission_role, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message = permission_roleService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<responseDTO> update(@PathVariable int id, @RequestBody permission_roleDTO permission_roleDTO) {
        responseDTO respuesta = permission_roleService.update(id, permission_roleDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}