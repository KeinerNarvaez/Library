package com.sena.crud_basic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


import com.sena.crud_basic.DTO.book_genreDTO;
import com.sena.crud_basic.DTO.responseDTO;

import com.sena.crud_basic.model.book;
import com.sena.crud_basic.model.book_genre;

import com.sena.crud_basic.model.genre;
import com.sena.crud_basic.repository.Ibook_genre;


@Service
public class book_genreService {
  @Autowired
   private Ibook_genre book_genreRepository;
   @Autowired
   private bookService bookService;
   @Autowired
   private genreService genreService;
   
   public List<book_genre> findAll() {
        return book_genreRepository.findAll();
    }

    public Optional<book_genre> findById(int id) {
        return book_genreRepository.findById(id);
    }
    public responseDTO delete(int id) {
        Optional<book_genre> book_genreOptional = findById(id);
        if (!book_genreOptional.isPresent()) {
            return new responseDTO(
                HttpStatus.NOT_FOUND,
                "The register does not exist"
            );
        }
        book_genreRepository.deleteById(id);
        return new responseDTO(
            HttpStatus.OK,
            "It was deleted correctly"
        );
    }
        public responseDTO update(int id, book_genreDTO book_genreDTO) {
        Optional<book_genre> existingbookOpt = findById(id);
    
        if (!existingbookOpt.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El registro no existe");
        }
        // Validar relaciones
        Optional<genre> genreOptional = genreService.findById(book_genreDTO.get_id_genre());
        if (!genreOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El genero no existe");
        }
    
        Optional<book> bookOptional = bookService.findById(book_genreDTO.get_id_book());
        if (!bookOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "La editorial no existe");
        }
        try {
            book_genre existingbook = existingbookOpt.get();
            existingbook.set_genre(genreOptional.get());
            existingbook.set_id_book(bookOptional.get());
    
            book_genreRepository.save(existingbook);
    
            return new responseDTO(HttpStatus.OK, "Libro actualizado correctamente");
        } catch (Exception e) {
            return new responseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar: " + e.getMessage());
        }
    }
    public responseDTO save(book_genreDTO book_genreDTO) {
      // Validar existencia del género
      Optional<genre> genreOptional = genreService.findById(book_genreDTO.get_id_genre());
      if (!genreOptional.isPresent()) {
          return new responseDTO(
              HttpStatus.NOT_FOUND,
              "The genre with ID " + book_genreDTO.get_id_genre() + " does not exist."
          );
      }
  
      // Validar existencia del libro
      Optional<book> bookOptional = bookService.findById(book_genreDTO.get_id_book());
      if (!bookOptional.isPresent()) {
          return new responseDTO(
              HttpStatus.NOT_FOUND,
              "The book with ID " + book_genreDTO.get_id_book() + " does not exist."
          );
      }
  
      // Convertir DTO a modelo con objetos completos
      book_genre book_genreRecord = convertToModel(
         book_genreDTO,
         bookOptional.get(),
         genreOptional.get()
     );
     
  
      book_genreRepository.save(book_genreRecord);
      return new responseDTO(HttpStatus.OK, "Book genre saved correctly.");
  }
  
  public book_genreDTO convertToDTO(book_genre book_genre) {
      return new book_genreDTO(
          book_genre.get_id_book_genre(),
          book_genre.get_id_genre().get_id_genre(),
          book_genre.get_id_book().get_id_book()
      );
  }
  

  public book_genre convertToModel(book_genreDTO book_genreDTO, book book, genre genre) {
   return new book_genre(
       0,
    genre,
    book
   );
}


}
