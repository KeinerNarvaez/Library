package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.editorialDTO;
import com.sena.crud_basic.model.editorial;
import com.sena.crud_basic.repository.Ieditorial;


@Service
public class editorialService {
  @Autowired
   private Ieditorial data;

   public void save(editorialDTO editorialDTO) {
      editorial editorial_Registro = converToModel(editorialDTO);
      data.save(editorial_Registro);
   }
   public editorialDTO convertToDTO(editorial editorial) {
      editorialDTO editorialDTO = new editorialDTO(
        editorial.get_id_editorial(),
        editorial.get_editorial(),
        editorial.get_id_country(),
        editorial.get_description()
      );
      return editorialDTO;
   }

   public editorial converToModel(editorialDTO editorialDTO) {    
      editorial editorial = new editorial(
        0,
        editorialDTO.get_editorial(),
        editorialDTO.get_id_country(),
        editorialDTO.get_description()
      );
      return editorial;
   }
}
