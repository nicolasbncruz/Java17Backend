package com.profesionaljava.examenfinal.clientes.services;

import com.profesionaljava.examenfinal.clientes.models.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

  public Iterable<Cliente> findAll();

  //en caso que no venga preguntamos antes de obtener al cliente
  public Optional<Cliente> findById(Long id);

  public Cliente save(Cliente cliente);

  public void deleteById(Long id);

}
