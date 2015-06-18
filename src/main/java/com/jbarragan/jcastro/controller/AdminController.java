package com.jbarragan.jcastro.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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

   @PostConstruct
   public void initialize() {
      typePost = PostEnum.ROUTE.getValue();
      listTypePost = new ArrayList<String>();
      listTypePost.add(PostEnum.ROUTE.getValue());
      listTypePost.add(PostEnum.STORY.getValue());
   }
   
   public boolean isRoute(){
      System.out.println("ROUTE: "+typePost.equals(PostEnum.ROUTE.getValue()));
      // return typePost.equals(PostEnum.ROUTE.getValue());
      return true;
   }
   
   public boolean isStory(){
      System.out.println("STORY: "+typePost.equals(PostEnum.STORY.getValue()));
      // return typePost.endsWith(PostEnum.STORY.getValue());
      return true;
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

}
