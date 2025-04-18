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

import com.sena.crud_basic.DTO.bill_loanDTO;
import com.sena.crud_basic.DTO.responseDTO;
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
        responseDTO respuesta = bill_loanService.save(bill_loan);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllbill_loan() {
        var lista = bill_loanService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBill_loan(@PathVariable int id) {
        var bill = bill_loanService.findById(id);
        if (!bill.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        var message= bill_loanService.delete(id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
        @PutMapping("/{id}")
    public ResponseEntity<responseDTO> updatebill_loan(
            @PathVariable int id,
            @RequestBody bill_loanDTO bill_loanDTO) {
        
        responseDTO respuesta = bill_loanService.update(id, bill_loanDTO);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }
}
