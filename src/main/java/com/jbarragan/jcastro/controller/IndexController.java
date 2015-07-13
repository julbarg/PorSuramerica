package com.jbarragan.jcastro.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jbarragan.jcastro.dao.PostDAO;
import com.jbarragan.jcastro.dto.ContactDTO;
import com.jbarragan.jcastro.dto.PostDTO;


@Controller("index")
@Scope("session")
public class IndexController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Autowired
   private PostDAO postDAO;

   private ArrayList<PostDTO> listPost;

   private PostDTO selectPost;

   private String textEdit;

   private String tituloWhere;

   private ArrayList<String> listMessage;

   private ArrayList<ContactDTO> contacts;

   @PostConstruct
   private void initialize() throws IOException {
      this.textEdit = "";
      this.tituloWhere = "¿DONDE PUTAS ESTAMOS?";
      this.listMessage = new ArrayList<String>();
      this.listMessage.add("Para la mayoría de las cosas importantes, el momento siempre es pésimo.");
      this.listMessage
         .add("¿Estás esperando un buen momento para dejar tu trabajo? Las estrellas nunca se alinearán y los semáforos de la vidad nunca se pondrán todos verdes al mismo tiempo. El universo no conspira contra ti, pero tampoco se volverá loco para apartarte obstáculos del camino. Las condiciones nunca serán las ideales. <<Algún día>> es  listas de pros y contras tampoco ayuda.");
      this.listMessage
         .add("Si algo es importante para ti y quieres hacerlo <<algún día>>, hazlo y corrige el rumbo mientras caminas.");
      this.contacts = new ArrayList<ContactDTO>();
      this.contacts.add(new ContactDTO("Julián Barragán Verano", "julbarg@gmail.com"));
      this.contacts.add(new ContactDTO("Johnatan Felipe Castro", "johntcastro@gmail.com"));
      loadPost();
      loadSelect();
      
      FacesContext.getCurrentInstance()
      .getExternalContext().redirect("pages/index.jsf");

   }

   private void loadSelect() {
      selectPost = new PostDTO();
   }

   private void loadPost() {
      try {
         PostDTO post;
         listPost = new ArrayList<PostDTO>();
         for (int i = 0; i < 8; i++) {
            post = new PostDTO();
            post.setTitle(i+". CALI ES CALI LO DEMAS ES LOMA");
            post.setCityFrom("Cali, Colombia");
            post.setCityTo("Popayan, Colombia");
            post.setDescription("Lorem Ipsum is simply dummy text "
               + "of the printing and typesetting industry. Lorem Ipsum has been "
               + "the industry's standard dummy text ever since the 1500s.");
            post.setDate("10 de enero de 2015");
            post.setImage("background-image:url('../resources/img/trujillo.jpg');");
            listPost.add(post);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
   
   public String goPost(){
	   return "post.xhtml";
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

   public String getTituloWhere() {
      return tituloWhere;
   }

   public void setTituloWhere(String tituloWhere) {
      this.tituloWhere = tituloWhere;
   }

   public ArrayList<String> getListMessage() {
      return listMessage;
   }

   public void setListMessage(ArrayList<String> listMessage) {
      this.listMessage = listMessage;
   }

   public ArrayList<ContactDTO> getContacts() {
      return contacts;
   }

   public void setContacts(ArrayList<ContactDTO> contacts) {
      this.contacts = contacts;
   }

   public PostDTO getSelectPost() {
      return selectPost;
   }

   public void setSelectPost(PostDTO selectPost) {
      this.selectPost = selectPost;
   }

}
