package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.model.country;
import com.sena.crud_basic.repository.Icountry;
import com.sena.crud_basic.DTO.editorialDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.editorial;
import com.sena.crud_basic.repository.Ieditorial;
import com.sena.crud_basic.service.countryService;


@Service
public class editorialService {
  @Autowired
   private Ieditorial data;

       public List<editorial> findAll() {
        return data.findAll();
    }

    public Optional<editorial> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteeditorial(int id) {
        if (!findById(id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "It was deleted correctly");
        return respuesta;
    }

    // register and update
    public responseDTO save(editorialDTO editorialDTO) {
        // validación longitud del nombre
        if (editorialDTO.get_editorial().length() < 1 ||
                editorialDTO.get_editorial().length() > 20) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre debe estar entre 1 y 20 caracteres");
            return respuesta;
        }
        // otras condiciones
        // n
        editorial editorial_Registro = converToModel(editorialDTO);
        data.save(editorial_Registro);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se guardó correctamente");
        return respuesta;

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
