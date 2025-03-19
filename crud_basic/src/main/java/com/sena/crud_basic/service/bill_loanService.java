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
            return new responseDTO(HttpStatus.NOT_FOUND.toString(), "La factura de préstamo no existe.");
        }
        billLoanRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Factura de préstamo eliminada correctamente.");
    }

    public responseDTO save(bill_loanDTO bill_loanDTO) {
        user_rol userRol = user_rolService.findById(bill_loanDTO.get_id_user_rol());
        if (userRol != null) {
            bill_loan billLoan = convertToModel(bill_loanDTO, userRol);
            billLoanRepository.save(billLoan);
            return new responseDTO(HttpStatus.OK.toString(), "Factura de préstamo guardada correctamente.");
        } else {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(),
                    "User_rol con ID " + bill_loanDTO.get_id_user_rol() + " no encontrado.");
        }
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
        // Aquí asignamos el user_rol completo al modelo
        return new bill_loan(
            0,  // Este valor puede ser auto-generado si tu base de datos usa una estrategia para la clave primaria
            bill_loanDTO.get_state(),
            bill_loanDTO.get_code(),
            LocalDate.now(),
            userRol // Asociamos el objeto user_rol completo
        );
    }
}