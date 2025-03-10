package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.loan_detailDTO;
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
        loan_detailService.save(loan_detail);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}