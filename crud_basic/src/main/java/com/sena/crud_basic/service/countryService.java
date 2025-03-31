package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.repository.Icountry;
import com.sena.crud_basic.model.country;



@Service
public class countryService {
  @Autowired
   private Icountry data;

   public List<country> findAll() {
      return data.findAll();
   }

   public Optional<country> findById(int id) {
      return data.findById(id);
   }
   public List<country> getListcountry() {
      return data.getListcountry();
   }
   public List<country> getListcountryForName(String filter) {
      return data.getListcountryForName(filter);
   }
   public responseDTO deletecountry(int id) {
      if (!findById(id).isPresent()) {
         responseDTO respuesta = new responseDTO(
               HttpStatus.OK,
               "The register does not exist");
         return respuesta;
   }
      data.deleteById(id);
        responseDTO respuesta = new responseDTO(
            HttpStatus.OK,
            "It was deleted correctly");
        return respuesta;
   }
       // register and update
   public responseDTO save(countryDTO countryDTO) {
         // validación longitud del nombre
         if (countryDTO.get_country().length() < 1 ||
                 countryDTO.get_country().length() > 50) {
             responseDTO respuesta = new responseDTO(
                     HttpStatus.BAD_REQUEST,
                     "El nombre debe estar entre 1 y 50 caracteres");
             return respuesta;
         }
         // otras condiciones
         // n
         country country_Registro = converToModel(countryDTO);
         data.save(country_Registro);
         responseDTO respuesta = new responseDTO(
                 HttpStatus.OK,
                 "Se guardó correctamente");
         return respuesta;
     }
   public countryDTO convertToDTO(country country) {
      countryDTO countryDTO = new countryDTO(
         country.get_id_country(),
         country.get_country()
      );
      return countryDTO;
   }

   public country converToModel(countryDTO countryDTO) {    
      country country = new country(
         0,
         countryDTO.get_country()
      );
      return country;
   }
}
