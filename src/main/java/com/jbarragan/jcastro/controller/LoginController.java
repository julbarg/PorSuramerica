package com.jbarragan.jcastro.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jbarragan.jcastro.dto.ContactDTO;


@Controller("login")
@Scope("session")
public class LoginController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private ContactDTO user;

   @PostConstruct
   private void initialize() {
      user = new ContactDTO();
   }

   public String signIn() {
      return "admin";
   }

   public ContactDTO getUser() {
      return user;
   }

   public void setUser(ContactDTO user) {
      this.user = user;
   }

}
