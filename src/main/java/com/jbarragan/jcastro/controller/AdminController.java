package com.jbarragan.jcastro.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jbarragan.jcastro.dto.CityDTO;
import com.jbarragan.jcastro.dto.RouteDTO;
import com.jbarragan.jcastro.enums.PostEnum;


@Controller("admin")
@Scope("request")
public class AdminController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private String typePost;

   private ArrayList<String> listTypePost;

   private RouteDTO route;

   private CityDTO city;

   private UploadedFile imageFront;

   @PostConstruct
   public void initialize() {
      typePost = PostEnum.ROUTE.getValue();
      listTypePost = new ArrayList<String>();
      listTypePost.add(PostEnum.ROUTE.getValue());
      listTypePost.add(PostEnum.STORY.getValue());
      route = new RouteDTO();
      city = new CityDTO();
   }
   
   public void loadImageFront(FileUploadEvent event) {
      try {
         imageFront = event.getFile();
         String fileName = imageFront.getFileName();
         System.out.println(fileName);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public String getTypePost() {
      return typePost;
   }

   public void setTypePost(String typePost) {
      this.typePost = typePost;
   }

   public ArrayList<String> getListTypePost() {
      return listTypePost;
   }

   public void setListTypePost(ArrayList<String> listTypePost) {
      this.listTypePost = listTypePost;
   }

   public RouteDTO getRoute() {
      return route;
   }

   public void setRoute(RouteDTO route) {
      this.route = route;
   }

   public CityDTO getCity() {
      return city;
   }

   public void setCity(CityDTO city) {
      this.city = city;
   }

   public UploadedFile getImageFront() {
      return imageFront;
   }

   public void setImageFront(UploadedFile imageFront) {
      this.imageFront = imageFront;
   }

}
