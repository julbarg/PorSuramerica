package com.claro.jbarragan.jcastro.dto;

import java.io.Serializable;


public class PostDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   private String title;

   private String cityFrom;

   private String cityTo;

   private String description;

   private String date;
   
   private String image;

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getCityFrom() {
      return cityFrom;
   }

   public void setCityFrom(String cityFrom) {
      this.cityFrom = cityFrom;
   }

   public String getCityTo() {
      return cityTo;
   }

   public void setCityTo(String cityTo) {
      this.cityTo = cityTo;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

}
