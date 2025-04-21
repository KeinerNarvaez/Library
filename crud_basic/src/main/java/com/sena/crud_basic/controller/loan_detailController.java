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

import com.sena.crud_basic.DTO.loan_detailDTO;
import com.sena.crud_basic.DTO.responseDTO;

import com.sena.crud_basic.service.loan_detailService;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/loan_detail")
public class loan_detailController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private loan_detailService loan_detailService;

    @PostMapping("/")
    public ResponseEntity<Object> registerloan_detail(@RequestBody loan_detailDTO loan_detail) {
        responseDTO respuesta = loan_detailService.save(loan_detail);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllloan_detail() {
        var lista = loan_detailService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneloan_detail(@PathVariable int id) {
        var loan_detail = loan_detailService.findById(id);
        if (!loan_detail.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(loan_detail, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= loan_detailService.delete(id); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/filter/{id_user}")
    public ResponseEntity<Object> getUserByUserBillId(@PathVariable int id_user) {
        var userList = loan_detailService.getUserByBillId(id_user);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }    
    @PutMapping("/{id}")
    public ResponseEntity<responseDTO> updateloan_detail(@PathVariable int id,@RequestBody loan_detailDTO loan_detailDTO) {
        responseDTO respuesta = loan_detailService.update(id, loan_detailDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}