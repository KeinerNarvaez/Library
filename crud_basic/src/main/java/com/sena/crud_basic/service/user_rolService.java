package com.sena.crud_basic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.user_rolDTO;
import com.sena.crud_basic.model.user_rol;
import com.sena.crud_basic.repository.Iuser_rol;

@Service

public class user_rolService {
   @Autowired
   private Iuser_rol data;

   public void save(user_rolDTO user_rolDTO) {
      user_rol user_rolRegister = converToModel(user_rolDTO);
      data.save(user_rolRegister);
   }
   public user_rolDTO convertToDTO(user_rol user_rol) {
      user_rolDTO user_rolDTO = new user_rolDTO(
      user_rol.get_id_user_rol(),
      user_rol.getUser(),
      user_rol.get_name_rol());
      return user_rolDTO;
   }

   public user_rol converToModel(user_rolDTO user_rolDTO) {
      user_rol user_rol = new user_rol(
      0,
      user_rolDTO.getUser(),
      user_rolDTO.get_name_rol());
      return user_rol;
   }
}