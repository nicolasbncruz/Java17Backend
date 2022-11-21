package com.nadhem.users.repos;

import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "sucursal")
@CrossOrigin(origins = "http://localhost:4200/")
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

  Sucursal findBySucursal(String sucursal);
}
