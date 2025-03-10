package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.rolesDTO;
import com.sena.crud_basic.model.roles;
import com.sena.crud_basic.repository.Iroles;


@Service
public class rolesService {
  @Autowired
   private Iroles data;

   public void save(rolesDTO rolesDTO) {
      roles roles_Registro = converToModel(rolesDTO);
      data.save(roles_Registro);
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