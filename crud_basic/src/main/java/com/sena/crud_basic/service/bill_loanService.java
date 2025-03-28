package com.sena.crud_basic.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.bill_loanDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.bill_loan;
import com.sena.crud_basic.model.user_rol;
import com.sena.crud_basic.repository.Ibill_loan;

@Service
public class bill_loanService {

    @Autowired
    private Ibill_loan billLoanRepository;

    @Autowired
    private user_rolService user_rolService;

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

    public responseDTO save(bill_loanDTO bill_loanDTO) {
        Optional<user_rol> user_rolOptional = user_rolService.findById(bill_loanDTO.get_id_user_rol());
        if (!user_rolOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "The user_rol with ID " + bill_loanDTO.get_id_user_rol() + " does not exist.");
        }

        // Convertimos el DTO en un modelo de bill_loan
        bill_loan billRecord = convertToModel(bill_loanDTO, user_rolOptional.get());

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
            bill_loan.get_id_user_rol().get_id_user_rol() // Usar el ID de user_rol
        );
    }

    // Convertir de bill_loanDTO a bill_loan
    public bill_loan convertToModel(bill_loanDTO bill_loanDTO, user_rol userRol) {
        return new bill_loan(
            0,  // ID generado automáticamente si la BD lo permite
            bill_loanDTO.get_state(),
            bill_loanDTO.get_code(),
            LocalDate.now(),
            userRol // Asociamos el objeto user_rol completo
        );
    }
}
