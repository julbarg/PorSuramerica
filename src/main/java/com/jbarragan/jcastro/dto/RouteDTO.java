package com.jbarragan.jcastro.dto;

import java.io.Serializable;


public class RouteDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private CityDTO cityOrigin;

   private CityDTO cityDestination;

   public CityDTO getCityOrigin() {
      return cityOrigin;
   }

   public CityDTO getCityDestination() {
      return cityDestination;
   }

   public float getDistance() {
      return distance;
   }

   public void setCityOrigin(CityDTO cityOrigin) {
      this.cityOrigin = cityOrigin;
   }

   public void setCityDestination(CityDTO cityDestination) {
      this.cityDestination = cityDestination;
   }

   public void setDistance(float distance) {
      this.distance = distance;
   }

   private float distance;

}
