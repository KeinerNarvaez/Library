package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.rolesDTO;

import com.sena.crud_basic.model.roles;

import com.sena.crud_basic.repository.Iroles;


@Service
public class rolesService {
  @Autowired
   private Iroles data;
       public List<roles> findAll() {
        return data.findAll();
    }

    public Optional<roles> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteroles(int id) {
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
        public responseDTO save(rolesDTO rolesDTO) {
        // validación longitud del nombre
        if (rolesDTO.get_name_rol().length() < 1 ||
                rolesDTO.get_name_rol().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST,
                    "El nombre debe estar entre 1 y 50 caracteres");
            return respuesta;
        }
        // otras condiciones
        // n
        roles roles_Registro = converToModel(rolesDTO);
        data.save(roles_Registro);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK,
                "Se guardó correctamente");
        return respuesta;

    }

   public rolesDTO convertToDTO(roles roles) {
      rolesDTO rolesDTO = new rolesDTO(
      roles.getid_roles(),
      roles.get_name_rol());
      return rolesDTO;
   }

   public roles converToModel(rolesDTO rolesDTO) {    
      roles roles = new roles(
      0,
      rolesDTO.get_name_rol());
      return roles;
   }
}