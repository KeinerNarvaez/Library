package com.sena.crud_basic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.book_genreDTO;
import com.sena.crud_basic.model.book_genre;
import com.sena.crud_basic.repository.Ibook_genre;


@Service
public class book_genreService {
  @Autowired
   private Ibook_genre data;

   public void save(book_genreDTO book_genreDTO) {
      book_genre book_Registro = converToModel(book_genreDTO);
      data.save(book_Registro);
   }
   public book_genreDTO convertToDTO(book_genre book_genre) {
      book_genreDTO book_genreDTO = new book_genreDTO(
        book_genre.get_id_book_genre(),
        book_genre.get_id_genre(),
        book_genre.get_id_book()
      );
      return book_genreDTO;
   }

   public book_genre converToModel(book_genreDTO book_genreDTO) {    
      book_genre book_genre = new book_genre(
        0,
        book_genreDTO.get_id_genre(),
        book_genreDTO.get_id_book()
      );
      return book_genre;
   }

}
