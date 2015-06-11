package com.jbarragan.jcastro.dao;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.claro.jbarragan.jcastro.enitity.PostEntity;


@Repository
public class PostDAOImpl extends TemplateDAO<PostEntity> implements PostDAO {

   @Override
   public PostEntity findById(long id) throws Exception {
      PostEntity alarmaPymeIVR = entityManager.find(PostEntity.class, id);

      return alarmaPymeIVR;
   }

   @Override
   public ArrayList<PostEntity> findAll() throws Exception {
      TypedQuery<PostEntity> query = entityManager.createNamedQuery("PostEntity.findAll",
         PostEntity.class);
      ArrayList<PostEntity> results = (ArrayList<PostEntity>) query.getResultList();

      return results;
   }
}
