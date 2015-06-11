package com.jbarragan.jcastro.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.claro.jbarragan.jcastro.enitity.PostEntity;
import com.jbarragan.jcastro.dao.PostDAO;


@Controller("porSuramerica")
@Scope("session")
public class PorSuramericaController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Autowired
   private PostDAO postDAO;

   private String textEdit;

   @PostConstruct
   private void initialize() {
      this.textEdit = "";
      loadPost();

   }

   private void loadPost() {
      try {
         ArrayList<PostEntity> listPost = new ArrayList<PostEntity>();
         listPost = postDAO.findAll();
         for (PostEntity post : listPost) {
            textEdit = textEdit + post;
         }
         PostEntity post = new PostEntity();
         post.setOrigen("Cali");
         post.setDestino("Popayam");
         post.setDescripcion("Cali - Popayan");
         postDAO.create(post);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public String getTextEdit() {
      return textEdit;
   }

   public void setTextEdit(String textEdit) {
      this.textEdit = textEdit;
   }

}
