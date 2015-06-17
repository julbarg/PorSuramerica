package com.jbarragan.jcastro.enitity;

import java.io.Serializable;

import javax.persistence.*;


/** The persistent class for the post database table. */
@Entity
@Table(
   name = "post")
@NamedQuery(
   name = "PostEntity.findAll", query = "SELECT p FROM PostEntity p")
public class PostEntity implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(
      strategy = GenerationType.AUTO)
   private int id;

   private String descripcion;

   private String destino;

   private String imagen;

   private String origen;

   public PostEntity() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDescripcion() {
      return this.descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public String getDestino() {
      return this.destino;
   }

   public void setDestino(String destino) {
      this.destino = destino;
   }

   public String getImagen() {
      return this.imagen;
   }

   public void setImagen(String imagen) {
      this.imagen = imagen;
   }

   public String getOrigen() {
      return this.origen;
   }

   public void setOrigen(String origen) {
      this.origen = origen;
   }

   @Override
   public String toString() {
      String message = this.origen + " " + this.destino + " " + this.descripcion;
      return message;
   }

}