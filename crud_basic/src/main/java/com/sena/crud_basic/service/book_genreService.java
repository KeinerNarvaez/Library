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
                HttpStatus.NOT_FOUND.toString(),
                "The register does not exist"
            );
        }
        book_genreRepository.deleteById(id);
        return new responseDTO(
            HttpStatus.OK.toString(),
            "It was deleted correctly"
        );
    }
    public responseDTO save(book_genreDTO book_genreDTO) {
      // Validar existencia del género
      Optional<genre> genreOptional = genreService.findById(book_genreDTO.get_id_genre());
      if (!genreOptional.isPresent()) {
          return new responseDTO(
              HttpStatus.NOT_FOUND.toString(),
              "The genre with ID " + book_genreDTO.get_id_genre() + " does not exist."
          );
      }
  
      // Validar existencia del libro
      Optional<book> bookOptional = bookService.findById(book_genreDTO.get_id_book());
      if (!bookOptional.isPresent()) {
          return new responseDTO(
              HttpStatus.NOT_FOUND.toString(),
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
      return new responseDTO(HttpStatus.OK.toString(), "Book genre saved correctly.");
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
