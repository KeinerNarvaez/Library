package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.crud_basic.DTO.editorialDTO;
import com.sena.crud_basic.DTO.responseDTO;

import com.sena.crud_basic.model.editorial;

import com.sena.crud_basic.model.country;
import com.sena.crud_basic.repository.Ieditorial;

@Service
public class editorialService {

    @Autowired
    private Ieditorial editorialRepository;

    @Autowired
    private countryService countryService;

    public List<editorial> findAll() {
        return editorialRepository.findAll();
    }

    public Optional<editorial> findById(int id) {
        return editorialRepository.findById(id);
    }

    public responseDTO delete(int id) {
        Optional<editorial> editorial = findById(id);
        if (!editorial.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "La editorial no existe.");
        }
        editorialRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK, "Editorial eliminada correctamente.");
    }
    @Transactional
    public responseDTO update(int id, editorialDTO editorialDTO) {
        Optional<editorial> existingeditorialOpt = findById(id);

        if (!existingeditorialOpt.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El registro no existe");
        }
        Optional<country> countryOptional = countryService.findById(editorialDTO.get_id_country());
        if (!countryOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El rol no existe");
        }
        try {
            editorial existingeditorial = existingeditorialOpt.get();

            existingeditorial.set_editorial(editorialDTO.get_editorial());
            existingeditorial.set_description(editorialDTO.get_description());
            existingeditorial.set_id_country(countryOptional.get());
            editorialRepository.save(existingeditorial);

            return new responseDTO(HttpStatus.OK, "Rol de usuario actualizado correctamente");
        } catch (Exception e) {
            return new responseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar: " + e.getMessage());
        }
    }
    public responseDTO save(editorialDTO editorialDTO) {
        if (editorialDTO.get_editorial().length() < 1 || editorialDTO.get_editorial().length() > 20) {
            
            return new responseDTO(HttpStatus.BAD_REQUEST, "El nombre debe estar entre 1 y 20 caracteres.");
        }
        
        Optional<country> countryOptional = countryService.findById(editorialDTO.get_id_country());
        if (!countryOptional.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, 
                "El país con ID " + editorialDTO.get_id_country() + " no existe.");
        }
        
        editorial editorial = convertToModel(editorialDTO, countryOptional.get());
        editorialRepository.save(editorial);
        return new responseDTO(HttpStatus.OK, "Editorial guardada correctamente.");
    }

    public editorialDTO convertToDTO(editorial editorial) {
        return new editorialDTO(
            editorial.get_id_editorial(),
            editorial.get_editorial(),
            editorial.get_id_country().get_id_country(), 
            editorial.get_description()
        );
    }

    public editorial convertToModel(editorialDTO editorialDTO, country country) {
        return new editorial(
            0,
            editorialDTO.get_editorial(),
            country, 
            editorialDTO.get_description()
        );
    }
}
