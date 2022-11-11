package com.cibertec.cursocliente.service.impl;

import com.cibertec.cursocliente.dto.CursoDTO;
import com.cibertec.cursocliente.repository.CursoRepository;
import com.cibertec.cursocliente.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

  @Autowired
  private CursoRepository cursoRepository;

  @Override
  public List<CursoDTO> listarTodos() {
    return cursoRepository.listarTodos();
  }

  @Override
  public CursoDTO obtenerCurso(Integer id) {
    return cursoRepository.obtenerCurso(id);
  }

  @Override
  public void insertar(CursoDTO cursoDTO) {
    cursoRepository.insertar(cursoDTO);
  }

  @Override
  public void actualizar(CursoDTO cursoDTO) {
    cursoRepository.actualizar(cursoDTO);
  }

  @Override
  public void eliminar(Integer idCurso) {
    cursoRepository.eliminar(idCurso);
  }
}
