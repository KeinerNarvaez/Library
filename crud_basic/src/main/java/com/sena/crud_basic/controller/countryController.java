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

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.service.countryService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/country")
public class countryController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private countryService countryService;

    @PostMapping("/")
    public ResponseEntity<Object> registereditorial(@RequestBody countryDTO country) {
        countryService.save(country);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }

            /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnecountry(@PathVariable int id) {
        var country = countryService.findById(id);
        if (!country.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletecountry(@PathVariable int id) {
        var message= countryService.deletecountry(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
