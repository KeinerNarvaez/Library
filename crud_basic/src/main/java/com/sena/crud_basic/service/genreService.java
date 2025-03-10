package com.sena.crud_basic.service;

import com.sena.crud_basic.repository.Igenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.genreDTO;

import com.sena.crud_basic.model.genre;

@Service
public class genreService {
  @Autowired
   private Igenre data;

   public void save(genreDTO genreDTO) {
      genre genre_Registro = converToModel(genreDTO);
      data.save(genre_Registro);
   }
   public genreDTO convertToDTO(genre genre) {
      genreDTO genreDTO = new genreDTO(
        genre.get_id_genre(),
        genre.get_genre()
      );
      return genreDTO;
   }

   public genre converToModel(genreDTO genreDTO) {    
      genre genre = new genre(
        0,
        genreDTO.get_genre()
      );
      return genre;
   }
}
