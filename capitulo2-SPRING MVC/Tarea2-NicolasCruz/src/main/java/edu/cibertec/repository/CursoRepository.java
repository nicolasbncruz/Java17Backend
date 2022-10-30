package edu.cibertec.repository;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.entity.UsuarioEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jpere
 */
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {

    //Consulta de cursos por estado haciendo uso de JPQL sin sentencias nativas
    @Query("SELECT c FROM CursoEntity c WHERE c.estado=?1")
    public List<CursoEntity> consultarPorEstado(Integer estado);

    //Consulta de cursos abiertos pero aun no completos usando NamedQuery
    //@NamedQuery("CursoEntity.abiertoIncompleto")
    public List<CursoEntity> abiertoIncompleto();

    //Consulta de cursos despues de la fecha usando @Param
    @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio>=:fecha")
    public List<CursoEntity> consultarPorFecha(@Param("fecha") Date fecha);

    //Consulta de cursos a los que les falta X numero de alumnos para llenarce usando Native Query con @Param
    @Query(value = "SELECT * FROM curso WHERE alumnosMin - alumnosAct=:cantidad", nativeQuery = true)
    public List<CursoEntity> consultarFaltantes(@Param("cantidad") Integer cantidad);

    //Consulta de cursos por su Nombre invocando un Stored Procedure
    //@Query(value="CALL Curso_Por_Nombre(:nombre)",nativeQuery = true) //luego usar @Param
    @Query(value = "CALL Curso_Por_Nombre(?1)", nativeQuery = true)
    public List<CursoEntity> consultarPorNombre(String nombre);

}
