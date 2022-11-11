package com.cibertec.cursocliente.repository.impl;

import com.cibertec.cursocliente.dto.CursoDTO;
import com.cibertec.cursocliente.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CursoRepositoryImpl implements CursoRepository {


  private RestTemplate restTemplate;

  @Value("${uri.rest.cursos}")
  private String urlServicio;

  public CursoRepositoryImpl(){
    restTemplate = new RestTemplate();
  }

  @Override
  public List<CursoDTO> listarTodos() {
    List<CursoDTO> respuesta = null;
    CursoDTO[] lista = restTemplate.getForObject(urlServicio, CursoDTO[].class);
    respuesta= Arrays.asList(lista);
    return respuesta;
  }

  @Override
  public CursoDTO obtenerCurso(Integer idCurso) {
//    CursoDTO respuesta = null;
    CursoDTO respuesta = restTemplate.getForObject(urlServicio+"/"+idCurso, CursoDTO.class);
    return respuesta;
  }

  @Override
  public void insertar(CursoDTO curso) {
    restTemplate.postForEntity(urlServicio, curso, CursoDTO.class);
  }

  @Override
  public void actualizar(CursoDTO curso) {
    restTemplate.put(urlServicio, curso, CursoDTO.class);
  }

  @Override
  public void eliminar(Integer idCurso) {
    restTemplate.delete(urlServicio+"/"+idCurso, CursoDTO.class);
  }
}
