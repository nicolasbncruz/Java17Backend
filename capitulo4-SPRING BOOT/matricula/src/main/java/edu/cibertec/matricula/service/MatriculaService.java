package edu.cibertec.matricula.service;

import edu.cibertec.matricula.entity.MatriculaEntity;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface MatriculaService {

    public List<MatriculaEntity> listaTodas();

    public void grabarMatricula(MatriculaEntity matriculaEntity);

}
