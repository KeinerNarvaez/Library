package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.author;

import com.sena.crud_basic.repository.Iauthor;

@Service
public class authorService {
    @Autowired
    private Iauthor data;

    public List<author> findAll() {
        return data.findAll();
    }

    public Optional<author> findById(int id) {
        return data.findById(id);
    }
    public List<author> getListauthor() {
      return data.getListauthor();
   }
   public List<author> getListauthorForName(String filter) {
      return data.getListauthorForName(filter);
   }

    public responseDTO deleteAuthor(int id) {
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
    public responseDTO save(authorDTO authorDTO) {
        // validación longitud del nombre
        if (authorDTO.get_author_name().length() < 1 ||
                authorDTO.get_author_name().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST,
                    "El nombre debe estar entre 1 y 50 caracteres");
            return respuesta;
        }
        // otras condiciones
        // n
        author author_Registro = convertToModel(authorDTO);
        data.save(author_Registro);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK,
                "Se guardó correctamente");
        return respuesta;

    }

    public authorDTO convertToDTO(author author) {
        authorDTO authorDTO = new authorDTO(
                author.get_id_author(),
                author.get_author_name(),
                author.get_biography());
        return authorDTO;
    }

    public author convertToModel(authorDTO authorDTO) {
        author author = new author(
                0,
                authorDTO.get_author_name(),
                authorDTO.get_biography());
        return author;
    }

}
