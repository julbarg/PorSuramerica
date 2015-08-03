package com.jbarragan.jcastro.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
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

   private String editor;

   @PostConstruct
   public void initialize() {
      typePost = PostEnum.ROUTE.getValue();
      listTypePost = new ArrayList<String>();
      listTypePost.add(PostEnum.ROUTE.getValue());
      listTypePost.add(PostEnum.STORY.getValue());
      route = new RouteDTO();
      route.setCityOrigin(new CityDTO());
      route.setCityDestination(new CityDTO());
      city = new CityDTO();
   }

   public void loadImageFront(FileUploadEvent event) {
      try {
         UploadedFile fileUpload = event.getFile();
         saveImage(fileUpload);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void saveImage(UploadedFile fileUpload) throws IOException {
      String filename = FilenameUtils.getName(fileUpload.getFileName());
      InputStream input = fileUpload.getInputstream();
      OutputStream output = new FileOutputStream(new File("C:/Users/jbarragan/Julian/PorSuramericaImg",
         filename));
      try {
         IOUtils.copy(input, output);
      } finally {
         IOUtils.closeQuietly(input);
         IOUtils.closeQuietly(output);
      }
   }

   public void save() {
      System.out.println("ssadsad");
      System.out.println(editor);
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

   public String getEditor() {
      return editor;
   }

   public void setEditor(String editor) {
      this.editor = editor;
   }

}
