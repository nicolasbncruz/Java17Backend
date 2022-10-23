package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jpere
 */

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
  public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);
}
