package com.cibertec.cursocliente.service;

import com.cibertec.cursocliente.dto.CursoDTO;

import java.util.List;

public interface CursoService {

  public List<CursoDTO> listarTodos();
  public CursoDTO obtenerCurso(Integer id);
  public void insertar(CursoDTO cursoDTO);
  public void actualizar(CursoDTO cursoDTO);
  public void eliminar(Integer idCurso);

}
