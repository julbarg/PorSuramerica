package com.jbarragan.jcastro.dto;

import java.io.Serializable;

public class ContactDTO implements Serializable{
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private String name;
   
   private String email;
   
   public ContactDTO(String name, String email) {
      this.name = name;
      this.email = email;
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
   


}
