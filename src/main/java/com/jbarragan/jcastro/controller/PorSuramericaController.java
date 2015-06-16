package com.jbarragan.jcastro.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.claro.jbarragan.jcastro.dto.PostDTO;
import com.jbarragan.jcastro.dao.PostDAO;


@Controller("porSuramerica")
@Scope("session")
public class PorSuramericaController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private ArrayList<PostDTO> listPost = new ArrayList<PostDTO>();

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
         PostDTO post;
         listPost = new ArrayList<PostDTO>();
         for (int i = 0; i < 8; i++) {
            post = new PostDTO();
            post.setTitle("01. CALI ES CALI LO DEMAS ES LOMA");
            post.setCityFrom("Cali, Colombia");
            post.setCityTo("Popayan, Colombia");
            post.setDescription("Lorem Ipsum is simply dummy text "
               + "of the printing and typesetting industry. Lorem Ipsum has been "
               + "the industry's standard dummy text ever since the 1500s.");
            post.setDate("10 de enero de 2015");
            post.setImage("background-image:url('resources/img/trujillo.jpg');");
            listPost.add(post);
         }

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

   public ArrayList<PostDTO> getListPost() {
      return listPost;
   }

   public void setListPost(ArrayList<PostDTO> listPost) {
      this.listPost = listPost;
   }

}
