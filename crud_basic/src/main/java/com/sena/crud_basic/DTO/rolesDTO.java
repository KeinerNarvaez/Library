package com.sena.crud_basic.DTO;

public class rolesDTO {
    private int id_roles;
    private String name_rol;
    public rolesDTO (int id_roles, String name_rol){
        this.id_roles = id_roles;
        this.name_rol = name_rol;
     }

     public int getid_roles() {
        return id_roles;
     }
     public void setid_roles(int id_roles){
        this.id_roles=id_roles;
     }
    public String get_name_rol() {
      return name_rol;
     }
    public void set_name_rol(String name_rol){
         this.name_rol=name_rol;
     }
}
