package com.nadhem.users.restControllers;

import com.nadhem.users.entities.Sucursal;
import com.nadhem.users.repos.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
@CrossOrigin("*")
public class SsucursalRestController {

  @Autowired
  SucursalRepository sucursalRepository;

  @RequestMapping(method= RequestMethod.GET)
  public List<Sucursal> getAllCategories()
  {
    return sucursalRepository.findAll();
  }

  @RequestMapping(value="/{id}",method = RequestMethod.GET)
  public Sucursal getCategorieById(@PathVariable("id") Long id) {
    return sucursalRepository.findById(id).get();
  }

}
