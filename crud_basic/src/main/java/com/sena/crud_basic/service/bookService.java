package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.bookDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.book;

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
                HttpStatus.NOT_FOUND,
                "The register does not exist"
            );
        }
        bookRepository.deleteById(id);
        return new responseDTO(
            HttpStatus.OK,
            "It was deleted correctly"
        );
    }

    public responseDTO save(bookDTO bookDTO) {  
        if (bookDTO.get_name_book().length() < 1 ||
        bookDTO.get_name_book().length() > 20) {
            responseDTO respuesta = new responseDTO(
            HttpStatus.BAD_REQUEST,
            "El nombre debe estar entre 1 y 20 caracteres");
        return respuesta;
        }
        // Validar existencia de country
        Optional<country> countryOptional = countryService.findById(bookDTO.get_id_country());
        if (!countryOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND,
                "The country with ID " + bookDTO.get_id_country() + " does not exist.");
        }

        // Validar existencia de editorial
        Optional<editorial> editorialOptional = editorialService.findById(bookDTO.get_id_editorial());
        if (!editorialOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND,
                "The editorial with ID " + bookDTO.get_id_editorial() + " does not exist.");
        }

        // Validar existencia de author
        Optional<author> authorOptional = authorService.findById(bookDTO.get_id_author_book());
        if (!authorOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND,
                "The author with ID " + bookDTO.get_id_author_book() + " does not exist.");
        }



        // Convertir DTO a modelo con objetos completos
        book bookRecord = convertToModel(
            bookDTO,
            countryOptional.get(),
            editorialOptional.get(),
            authorOptional.get()
        );

        bookRepository.save(bookRecord);
        return new responseDTO(HttpStatus.OK, "Book saved correctly.");
    }

    public bookDTO convertToDTO(book book) {
        return new bookDTO(
            book.get_id_book(),
            book.get_name_book(),
            book.get_image(),
            book.get_id_country().get_id_country(),
            book.get_id_editorial().get_id_editorial(),
            book.get_id_author_book().get_id_author()
        );
    }

    public book convertToModel(bookDTO bookDTO, country country, editorial editorial, author author) {
        return new book(
            0,  
            bookDTO.get_name_book(),
            bookDTO.get_image(),
            country,
            editorial,
            author
        );
    }
}

