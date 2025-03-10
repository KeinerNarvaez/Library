package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.rolesDTO;
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
        rolesService.save(roles);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}