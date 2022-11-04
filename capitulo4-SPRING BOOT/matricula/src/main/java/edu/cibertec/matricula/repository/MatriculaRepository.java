package edu.cibertec.matricula.repository;

import edu.cibertec.matricula.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jpere
 */
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {
}
