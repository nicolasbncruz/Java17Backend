package com.profesionaljava.examenfinal.clientes.controllers;

import com.profesionaljava.examenfinal.clientes.models.entity.Cliente;
import com.profesionaljava.examenfinal.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<?> obtenerClientes(){
    return ResponseEntity.ok().body(clienteService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCliente(@PathVariable(name = "idCliente", required = true) Long idCliente){
    Optional<Cliente> optionalCliente = clienteService.findById(idCliente);
    if (optionalCliente.isEmpty()){
      return ResponseEntity.notFound().build();
    }else {
      return ResponseEntity.ok(optionalCliente.get());
    }
  }

  @PostMapping
  public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
    Cliente clienteSaved = clienteService.save(cliente);
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente,
                                             @PathVariable(name = "idCliente", required = true) Long idCliente){
    Optional<Cliente> optionalCliente = clienteService.findById(idCliente);
    if (optionalCliente.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    Cliente clienteUpdate = optionalCliente.get();
    clienteUpdate.setNombre(cliente.getNombre());
    clienteUpdate.setApellido(cliente.getApellido());
    clienteUpdate.setEmail(cliente.getEmail());
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteUpdate));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminarCliente(@PathVariable(name = "idCliente", required = true) Long idCliente){
    clienteService.deleteById(idCliente);
    return ResponseEntity.noContent().build();
  }

}
