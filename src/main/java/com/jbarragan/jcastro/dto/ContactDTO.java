package com.jbarragan.jcastro.dto;

import java.io.Serializable;


public class ContactDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private String userName;

   private String password;

   private String name;

   private String email;

   public ContactDTO(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public ContactDTO() {

   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
