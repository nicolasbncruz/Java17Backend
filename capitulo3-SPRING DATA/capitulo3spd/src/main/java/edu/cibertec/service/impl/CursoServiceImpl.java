package edu.cibertec.service.impl;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> consultarPorEstado(Integer estado) {
        return cursoRepository.consultarPorEstado(estado);
    }

    @Override
    public List<CursoEntity> abiertoIncompleto() {
        return cursoRepository.abiertoIncompleto();
    }

    @Override
    public List<CursoEntity> consultarPorFecha(Date fecha) {
        return cursoRepository.consultarPorFecha(fecha);
    }

    @Override
    public List<CursoEntity> consultarFaltantes(Integer cantidad) {
        return cursoRepository.consultarFaltantes(cantidad);
    }

    @Override
    public List<CursoEntity> consultarPorNombre(String nombre) {
        return cursoRepository.consultarPorNombre(nombre);
    }

}
