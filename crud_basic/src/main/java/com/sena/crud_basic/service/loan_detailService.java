package com.sena.crud_basic.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.loan_detailDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.loan_detail;
import com.sena.crud_basic.model.bill_loan;
import com.sena.crud_basic.model.book;
import com.sena.crud_basic.repository.Iloan_detail;

@Service
public class loan_detailService {

    @Autowired
    private Iloan_detail loanDetailRepository;

    @Autowired
    private bookService bookService;
    
    @Autowired
    private bill_loanService billLoanService;

    public Optional<loan_detail> findById(int id) {
        return loanDetailRepository.findById(id);
    }
        public List<loan_detail> findAll() {
      return loanDetailRepository.findAll();
   }

    public responseDTO delete(int id) {
        Optional<loan_detail> loanDetailOptional = findById(id);
        if (!loanDetailOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "The register does not exist");
        }
        loanDetailRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK, "It was deleted correctly");
    }

    public responseDTO save(loan_detailDTO loan_detailDTO) {  
      // Validar existencia de book
      Optional<book> bookOptional = bookService.findById(loan_detailDTO.get_id_book());
      if (!bookOptional.isPresent()) {
          return new responseDTO(HttpStatus.NOT_FOUND, "The book with ID " + loan_detailDTO.get_id_book() + " does not exist.");
      }
  
      // Validar existencia de bill_loan
      Optional<bill_loan> billLoanOptional = billLoanService.findById(loan_detailDTO.get_id_bill());
      if (!billLoanOptional.isPresent()) {
          return new responseDTO(HttpStatus.NOT_FOUND, "The bill loan with ID " + loan_detailDTO.get_id_bill() + " does not exist.");
      }
  
  
      // Convertir DTO a modelo con objetos completos
      loan_detail loanDetailRecord = convertToModel(loan_detailDTO, billLoanOptional.get(), bookOptional.get());
  
      // Guardar en la base de datos
      loanDetailRepository.save(loanDetailRecord);
      return new responseDTO(HttpStatus.OK, "Loan detail saved correctly.");
  }

    public loan_detailDTO convertToDTO(loan_detail loanDetail) {
        return new loan_detailDTO(
            loanDetail.get_id_loan_detail(),
            loanDetail.get_id_bill().get_id_bill(),
            loanDetail.get_state(),
            loanDetail.get_return_date(),
            loanDetail.get_id_book().get_id_book()
        );
    }

    public loan_detail convertToModel(loan_detailDTO loan_detailDTO, bill_loan billLoan, book book) {
        return new loan_detail(
            0,  
            billLoan,
            loan_detailDTO.get_state(),
            LocalDateTime.now(),
            book
        );
    }
}
