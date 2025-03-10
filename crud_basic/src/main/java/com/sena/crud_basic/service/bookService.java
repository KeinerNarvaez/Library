package com.sena.crud_basic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.bookDTO;
import com.sena.crud_basic.model.book;
import com.sena.crud_basic.repository.Ibook;
@Service
public class bookService {
  @Autowired
   private Ibook data;

   public void save(bookDTO bookDTO) {
      book book_Registro = converToModel(bookDTO);
      data.save(book_Registro);
   }
   public bookDTO convertToDTO(book book) {
      bookDTO bookDTO = new bookDTO(
        book.get_id_book(),
        book.get_name_book(),
        book.get_id_country(),
        book.get_id_editorial(),
        book.get_id_author_book(),
        book.get_id_book_genre()
      );
      return bookDTO;
   }

   public book converToModel(bookDTO bookDTO) {    
      book book = new book(
        0,
        bookDTO.get_name_book(),
        bookDTO.get_id_country(),
        bookDTO.get_id_editorial(),
        bookDTO.get_id_author_book(),
        bookDTO.get_id_book_genre()
        );
      return book;
   }
}
