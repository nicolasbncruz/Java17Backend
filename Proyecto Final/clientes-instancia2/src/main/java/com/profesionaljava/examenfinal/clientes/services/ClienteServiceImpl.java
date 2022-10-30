package com.profesionaljava.examenfinal.clientes.services;

import com.profesionaljava.examenfinal.clientes.models.entity.Cliente;
import com.profesionaljava.examenfinal.clientes.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  @Transactional(readOnly = true)
  public Iterable<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Cliente> findById(Long id) {
    return clienteRepository.findById(id);
  }

  @Override
  @Transactional
  public Cliente save(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    clienteRepository.deleteById(id);
  }
}
