package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.loan_detailDTO;
import com.sena.crud_basic.model.loan_detail;   
import com.sena.crud_basic.repository.Iloan_detail;

@Service
public class loan_detailService {
  @Autowired
   private Iloan_detail data;

   public void save(loan_detailDTO loan_detailDTO) {
      loan_detail loan_detail_Registro = converToModel(loan_detailDTO);
      data.save(loan_detail_Registro);
   }
   public loan_detailDTO convertToDTO(loan_detail loan_detail) {
      loan_detailDTO loan_detailDTO = new loan_detailDTO(
        loan_detail.get_id_loan_detail(),
        loan_detail.get_id_bill(),
        loan_detail.get_state(),
        loan_detail.get_return_date(),
        loan_detail.get_id_book(),
        loan_detail.get_id_user_rol()
      );
      return loan_detailDTO;
   }

   public loan_detail converToModel(loan_detailDTO loan_detailDTO) {    
      loan_detail loan_detail = new loan_detail(
        0,
        loan_detailDTO.get_id_bill(),
        loan_detailDTO.get_state(),
        loan_detailDTO.get_return_date(),
        loan_detailDTO.get_id_book(),
        loan_detailDTO.get_id_user_rol()
      );
      return loan_detail;
   }
}
