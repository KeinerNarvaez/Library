package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.roles;
import com.sena.crud_basic.model.user;

public class user_rolDTO {
   private int id_user_rol;
   private user user;
   private roles id_rol;
   public user_rolDTO(int id_user_rol,com.sena.crud_basic.model.user user, roles id_rol) {
      this.id_user_rol = id_user_rol;
      this.user = user;
      this.id_rol = id_rol;
   }
   public void set_id_user_rol(int id_user_rol) {
      this.id_user_rol = id_user_rol;
   }

   public int get_id_user_rol() {
      return id_user_rol;
   }

   public user getUser() {
      return user;
   }

   public void setUser(user user) {
      this.user = user;
   }

   public roles get_name_rol() {
      return id_rol;
   }

   public void set_name_rol(roles id_rol) {
      this.id_rol = id_rol;
   }
}
