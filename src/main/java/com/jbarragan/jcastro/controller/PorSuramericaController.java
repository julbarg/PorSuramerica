package com.jbarragan.jcastro.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@ManagedBean("porSuramerica")
@Scope("session")
public class PorSuramericaController {

   private String textEdit;

   @PostConstruct
   private void initialize() {
      this.textEdit = "Prototype";
   }

   public String getTextEdit() {
      return textEdit;
   }

   public void setTextEdit(String textEdit) {
      this.textEdit = textEdit;
   }

}
