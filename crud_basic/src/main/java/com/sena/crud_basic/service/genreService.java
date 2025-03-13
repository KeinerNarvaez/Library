package com.sena.crud_basic.service;

import com.sena.crud_basic.repository.Igenre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.genreDTO;
import com.sena.crud_basic.DTO.responseDTO;

import com.sena.crud_basic.model.genre;

@Service
public class genreService {
  @Autowired
   private Igenre data;

    public List<genre> findAll() {
      return data.findAll();
   }

   public Optional<genre> findById(int id) {
      return data.findById(id);
   }
   public responseDTO deletegenre(int id) {
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
   public responseDTO save(genreDTO genreDTO) {
        // validación longitud del nombre
        if (genreDTO.get_genre().length() < 1 ||
                genreDTO.get_genre().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre debe estar entre 1 y 50 caracteres");
            return respuesta;
        }
        // otras condiciones
        // n
        genre genre_Registro = converToModel(genreDTO);
        data.save(genre_Registro);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se guardó correctamente");
        return respuesta;

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
