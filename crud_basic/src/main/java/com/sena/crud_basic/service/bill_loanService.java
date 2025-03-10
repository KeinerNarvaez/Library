package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.bill_loanDTO;
import com.sena.crud_basic.model.bill_loan;
import com.sena.crud_basic.repository.Ibill_loan;

@Service
public class bill_loanService {
  @Autowired
   private Ibill_loan data;

   public void save(bill_loanDTO bill_loanDTO) {
      bill_loan bill_Registro = convertToModel(bill_loanDTO); 
      data.save(bill_Registro);
   }
   public bill_loanDTO convertToDTO(bill_loan bill_loan) {
      bill_loanDTO bill_loanDTO = new bill_loanDTO(
          bill_loan.get_id_bill(),
          bill_loan.get_state(),
          bill_loan.get_code(),
          bill_loan.get_date(),
          bill_loan.get_id_user_rol()
      );
      return bill_loanDTO;
  }

  public bill_loan convertToModel(bill_loanDTO bill_loanDTO) {    
      bill_loan bill_loan = new bill_loan(
          0,  
          bill_loanDTO.get_state(),
          bill_loanDTO.get_code(),
          bill_loanDTO.get_date(), 
          bill_loanDTO.get_id_user_rol()
      );
      return bill_loan;
  }
}
