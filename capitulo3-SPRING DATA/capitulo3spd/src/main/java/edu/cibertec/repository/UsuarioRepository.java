package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jpere
 */

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
  public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);
  //@Query("SELECT u FROM UsuarioEntity u WHERE u.usuario LIKE CONCAT('%',?1,'%') ")
  //@Query("SELECT u FROM UsuarioEntity u WHERE u.usuario LIKE  %?1%")
  @Query(value="SELECT * FROM usuario WHERE usuario LIKE  %?1%",nativeQuery = true)
  public List<UsuarioEntity> findByUsuarioLike(String usuario);
  @Modifying
  @Query(value = "insert into usuario (usuario, clave, nombreApellido, foto) VALUES (:#{#usuario.usuario},:#{#usuario.clave},:#{#usuario.nombreApellido},:#{#usuario.foto})", nativeQuery = true)
  public void insertarUsuario(@Param("usuario") UsuarioEntity usuario);
  
}
