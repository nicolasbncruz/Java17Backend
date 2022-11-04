package edu.cibertec.sec04.service;

import edu.cibertec.sec04.entity.*;
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
