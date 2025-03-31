package com.sena.crud_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.rolesDTO;

import com.sena.crud_basic.model.roles;
import com.sena.crud_basic.service.rolesService;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/roles")
public class rolesController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private rolesService rolesService;

    @PostMapping("/")
    public ResponseEntity<Object> registerroles(@RequestBody rolesDTO roles) {
        responseDTO respuesta = rolesService.save(roles);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
        @GetMapping("/{id}")
    public ResponseEntity<Object> getOneroles(@PathVariable int id) {
        var roles = rolesService.findById(id);
        if (!roles.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteroles(@PathVariable int id) {
        var message= rolesService.deleteroles(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
        @GetMapping("/Listroles")
    public ResponseEntity<List<roles>> getListroles() {
        return ResponseEntity.ok(rolesService.getListroles());
    }
    @GetMapping("/filter/{filter}")
    public ResponseEntity<Object> getListrolesForName(@PathVariable String filter) {
        var rolesList = rolesService.getListrolesForName(filter);
        return new ResponseEntity<>(rolesList, HttpStatus.OK);
    }
}