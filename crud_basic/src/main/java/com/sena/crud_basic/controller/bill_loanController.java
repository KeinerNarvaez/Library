package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crud_basic.DTO.bill_loanDTO;
import com.sena.crud_basic.service.bill_loanService;


import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/bill_loan")
public class bill_loanController {
    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private bill_loanService bill_loanService;

    @PostMapping("/")
    public ResponseEntity<Object> registerbill_loan(@RequestBody bill_loanDTO bill_loan) {
        bill_loanService.save(bill_loan);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
}
