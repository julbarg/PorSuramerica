package com.jbarragan.jcastro.dto;

import java.io.Serializable;


public class CityDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private String name;

   private Float lat;

   private Float lng;

   public String getName() {
      return name != null ? name : "";
   }

   public Float getLat() {
      return lat;
   }

   public Float getLng() {
      return lng;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setLat(Float lat) {
      this.lat = lat;
   }

   public void setLng(Float lng) {
      this.lng = lng;
   }

}
