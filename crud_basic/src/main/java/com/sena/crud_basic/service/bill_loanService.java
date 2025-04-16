package com.sena.crud_basic.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.bill_loanDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.bill_loan;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.repository.Ibill_loan;

@Service
public class bill_loanService {

    @Autowired
    private Ibill_loan billLoanRepository;

    @Autowired
    private userService userService;

    public List<bill_loan> findAll() {
        return billLoanRepository.findAll();
    }

    // Buscar por ID
    public Optional<bill_loan> findById(int id) {
        return billLoanRepository.findById(id);
    }

    public responseDTO delete(int id) {
        Optional<bill_loan> billLoan = findById(id);
        if (!billLoan.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "La factura de préstamo no existe.");
        }
        billLoanRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK, "Factura de préstamo eliminada correctamente.");
    }
    
    public responseDTO update(int id, bill_loanDTO billLoanDTO) {
        Optional<bill_loan> existingLoanOpt = findById(id);
    
        if (!existingLoanOpt.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "La factura de préstamo no existe.");
        }
    
        Optional<user> userOptional = userService.findById(billLoanDTO.get_id_user());
        if (!userOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El usuario no existe.");
        }
    
        try {
            bill_loan existingLoan = existingLoanOpt.get();
            existingLoan.set_state(billLoanDTO.get_state());
            existingLoan.set_code(billLoanDTO.get_code());
            existingLoan.set_id_user(userOptional.get());
    
            billLoanRepository.save(existingLoan);
    
            return new responseDTO(HttpStatus.OK, "Factura de préstamo actualizada correctamente.");
        } catch (Exception e) {
            return new responseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar: " + e.getMessage());
        }
    }
    

    public responseDTO save(bill_loanDTO bill_loanDTO) {
        Optional<user> userOptional = userService.findById(bill_loanDTO.get_id_user());
        if (!userOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "The user with ID " + bill_loanDTO.get_id_user() + " does not exist.");
        }

        // Convertimos el DTO en un modelo de bill_loan
        bill_loan billRecord = convertToModel(bill_loanDTO, userOptional.get());

        // Guardar en la base de datos
        billLoanRepository.save(billRecord);
        return new responseDTO(HttpStatus.OK, "Loan bill saved correctly.");
    }

    // Convertir de bill_loan a bill_loanDTO
    public bill_loanDTO convertToDTO(bill_loan bill_loan) {
        return new bill_loanDTO(
            bill_loan.get_id_bill(),
            bill_loan.get_state(),
            bill_loan.get_code(),
            bill_loan.get_date(),
            bill_loan.get_id_user().getId_user() // Usar el ID de user
        );
    }

    // Convertir de bill_loanDTO a bill_loan
    public bill_loan convertToModel(bill_loanDTO bill_loanDTO, user userRol) {
        return new bill_loan(
            0,  // ID generado automáticamente si la BD lo permite
            bill_loanDTO.get_state(),
            bill_loanDTO.get_code(),
            LocalDateTime.now(),
            userRol // Asociamos el objeto user completo
        );
    }
}
