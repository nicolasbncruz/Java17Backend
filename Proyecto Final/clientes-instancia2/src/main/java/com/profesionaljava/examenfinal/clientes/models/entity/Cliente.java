package com.profesionaljava.examenfinal.clientes.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String apellido;
  private String email;

  @PrePersist
  public void prePersist(){
    this.fechaCreacion = new Date();
  }

  @Column(name = "fecha_creacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaCreacion;
}
