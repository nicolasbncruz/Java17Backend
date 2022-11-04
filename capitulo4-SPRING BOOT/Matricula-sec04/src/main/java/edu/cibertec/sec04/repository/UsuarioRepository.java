package edu.cibertec.sec04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.cibertec.sec04.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
	  public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);
	  //@Query("SELECT u FROM UsuarioEntity u WHERE u.usuario LIKE CONCAT('%',?1,'%') ")
	  //@Query("SELECT u FROM UsuarioEntity u WHERE u.usuario LIKE  %?1%")
	  @Query(value="SELECT * FROM usuario WHERE usuario LIKE  %?1%",nativeQuery = true)
	  public List<UsuarioEntity> findByUsuarioLike(String usuario);
	  @Modifying
	  @Query(value = "insert into usuario (usuario, clave, nombreApellido, foto) VALUES (:#{#usuario.usuario},:#{#usuario.clave},:#{#usuario.nombreApellido},:#{#usuario.foto})", nativeQuery = true)
	  public void insertarUsuario(@Param("usuario") UsuarioEntity usuario);
	  
	  //usuario, clave, id, apellido, foto
	//  @Modifying
	//  @Query(value = "CALL SP_ACTUALIZAR_USUARIO_VALIDATOR(:#{#usuario.usuario},:#{#usuario.clave},:#{#usuario.idUsuario},:#{#usuario.nombreApellido},:#{#usuario.foto})", nativeQuery = true)
	//  public void actualizarData(@Param("usuario") UsuarioEntity usuario);
	  
	}
