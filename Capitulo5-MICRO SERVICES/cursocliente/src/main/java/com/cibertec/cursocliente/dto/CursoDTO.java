package com.cibertec.cursocliente.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CursoDTO {

  private Integer idCurso;
  private String nomCurso;
  private Date fechaInicio;
  private Integer alumnosMin;
  private Integer alumnosAct;
  private Integer estado;

}
