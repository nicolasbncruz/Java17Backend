package com.profesionaljava.examenfinal.clientes.models.repository;

import com.profesionaljava.examenfinal.clientes.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
