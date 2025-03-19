package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.bookDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.book;
import com.sena.crud_basic.model.book_genre;
import com.sena.crud_basic.model.country;
import com.sena.crud_basic.model.editorial;
import com.sena.crud_basic.model.author;
import com.sena.crud_basic.repository.Ibook;

@Service
public class bookService {

    @Autowired
    private Ibook bookRepository;

    @Autowired
    private countryService countryService;

    @Autowired
    private editorialService editorialService;

    @Autowired
    private authorService authorService;

    @Autowired
    private book_genreService bookGenreService;

    public List<book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<book> findById(int id) {
        return bookRepository.findById(id);
    }

    public responseDTO delete(int id) {
        Optional<book> bookOptional = findById(id);
        if (!bookOptional.isPresent()) {
            return new responseDTO(
                HttpStatus.NOT_FOUND.toString(),
                "The register does not exist"
            );
        }
        bookRepository.deleteById(id);
        return new responseDTO(
            HttpStatus.OK.toString(),
            "It was deleted correctly"
        );
    }

    public responseDTO save(bookDTO bookDTO) {
        // Validar existencia de country
        Optional<country> countryOptional = countryService.findById(bookDTO.get_id_country());
        if (!countryOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(),
                "The country with ID " + bookDTO.get_id_country() + " does not exist.");
        }

        // Validar existencia de editorial
        Optional<editorial> editorialOptional = editorialService.findById(bookDTO.get_id_editorial());
        if (!editorialOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(),
                "The editorial with ID " + bookDTO.get_id_editorial() + " does not exist.");
        }

        // Validar existencia de author
        Optional<author> authorOptional = authorService.findById(bookDTO.get_id_author_book());
        if (!authorOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(),
                "The author with ID " + bookDTO.get_id_author_book() + " does not exist.");
        }

        // Validar existencia de book_genre
        Optional<book_genre> bookGenreOptional = bookGenreService.findById(bookDTO.get_id_book_genre());
        if (!bookGenreOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(),
                "The book genre with ID " + bookDTO.get_id_book_genre() + " does not exist.");
        }

        // Convertir DTO a modelo con objetos completos
        book bookRecord = convertToModel(
            bookDTO,
            countryOptional.get(),
            editorialOptional.get(),
            authorOptional.get(),
            bookGenreOptional.get()
        );

        bookRepository.save(bookRecord);
        return new responseDTO(HttpStatus.OK.toString(), "Book saved correctly.");
    }

    public bookDTO convertToDTO(book book) {
        return new bookDTO(
            book.get_id_book(),
            book.get_name_book(),
            book.get_id_country().get_id_country(),
            book.get_id_editorial().get_id_editorial(),
            book.get_id_author_book().get_id_author(),
            book.get_id_book_genre().get_id_book_genre()
        );
    }

    public book convertToModel(bookDTO bookDTO, country country, editorial editorial, author author, book_genre bookGenre) {
        return new book(
            0,  // ID en 0 si es nuevo
            bookDTO.get_name_book(),
            country,
            editorial,
            author,
            bookGenre
        );
    }
}

