package com.jbarragan.jcastro.dao;

import java.util.ArrayList;

import com.jbarragan.jcastro.enitity.PostEntity;


public interface PostDAO {

   public PostEntity update(PostEntity alarmaPymeIVR);

   public PostEntity findById(long id) throws Exception;

   public ArrayList<PostEntity> findAll() throws Exception;

   public void create(PostEntity post);

}
