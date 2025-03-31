package com.sena.crud_basic.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "user")

public class user {
   /*
    * atributos o columnas de la entidad
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_user")
   private int id_user;

   @Column(name = "name", length = 50, nullable = false)
   private String name;

   @Column(name = "email", length = 150, nullable = false)
   private String email;

   @Column(name = "password", length = 150, nullable = false)
   private String password;

   @Column(name = "number", length = 150, nullable = false)
   private int number;

   @Column(name = "registration_date", nullable = false)
   private LocalDateTime registration_date;

   @Column(name="status",nullable =false, columnDefinition = "boolean default true ")
   private boolean status;

   
   
   public user() {
   }

   public user(int id_user, String name, String email, String password, int number,
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

   public int get_number() {
      return number;
   }

   // set del phone
   public void set_number(int number) {
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