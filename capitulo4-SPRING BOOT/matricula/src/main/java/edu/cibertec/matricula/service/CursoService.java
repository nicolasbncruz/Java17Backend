package edu.cibertec.matricula.service;

import edu.cibertec.matricula.entity.CursoEntity;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface CursoService {

    public List<CursoEntity> consultarPorEstado(Integer estado);

    public List<CursoEntity> abiertoIncompleto();

    public List<CursoEntity> consultarPorFecha(Date fecha);

    public List<CursoEntity> consultarFaltantes(Integer cantidad);

    public List<CursoEntity> consultarPorNombre(String nombre);
}
