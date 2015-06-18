package com.jbarragan.jcastro.enums;

public enum PostEnum {

   ROUTE("route"), STORY("story");

   private String value;

   private PostEnum(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

}
