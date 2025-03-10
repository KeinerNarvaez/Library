package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.model.author;
import com.sena.crud_basic.repository.Iauthor;

@Service
public class authorService {
  @Autowired
   private Iauthor data;

   public void save(authorDTO authorDTO) {
      author author_Registro = convertToModel(authorDTO); 
      data.save(author_Registro);
   }
   public authorDTO convertToDTO(author author) {
      authorDTO authorDTO = new authorDTO(
          author.get_id_author(),
          author.get_author_name(),
          author.get_biography()
      );
      return authorDTO;
  }

  public author convertToModel(authorDTO authorDTO) {    
      author author = new author(
          0,
          authorDTO.get_author_name(),
          authorDTO.get_biography()
          );
      return author;
  }

}
