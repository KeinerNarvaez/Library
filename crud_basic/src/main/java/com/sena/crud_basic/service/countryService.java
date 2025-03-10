package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.repository.Icountry;
import com.sena.crud_basic.model.country;


@Service
public class countryService {
  @Autowired
   private Icountry data;

   public void save(countryDTO countryDTO) {
      country country_Registro = converToModel(countryDTO);
      data.save(country_Registro);
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
