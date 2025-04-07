package com.sena.crud_basic.DTO;
import java.time.LocalDateTime;
public class userDTO {


   private int id_user;

   private String name;


   private String email;


   private String password;

   private String number;


   private LocalDateTime registration_date;

   private boolean status;
   public userDTO(int id_user, String name, String email, String password, String number,
         LocalDateTime registration_date, boolean status) {
      this.id_user = id_user;
      this.name = name;
      this.email = email;
      this.password = password;
      this.number = number;
      this.registration_date = registration_date;
      this.status = status;
   }

   // get del ID
   public int getId_user() {
      return id_user;
   }

   // set del ID
   public void setId_user(int id_user) {
      this.id_user = id_user;
   }

   // get del firstName
   public String get_name() {
      return name;
   }

   // set del firstName
   public void set_breedName(String name) {
      this.name = name;
   }

   // get del phone
   public String get_password() {
      return password;
   }

   // set del phone
   public void set_password(String password) {
      this.password = password;
   }

   public String get_number() {
      return number;
   }

   // set del phone
   public void set_number(String number) {
      this.number = number;
   }

   public LocalDateTime get_registration_date() {
      return registration_date;
   }

   // set del phone
   public void set_registration_date(LocalDateTime registration_date) {
      this.registration_date = registration_date;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean getStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }
}