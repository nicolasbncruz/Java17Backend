package edu.cibertec.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author jpere
 */
@Data
@Entity
@Table(name = "curso")
@NamedQuery(name = "CursoEntity.abiertoIncompleto", query = "SELECT c FROM CursoEntity c WHERE c.alumnosMin>c.alumnosAct AND c.estado=1")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    @NotNull
    private String nomCurso;
    @NotNull
    private Date fechaInicio;
    @NotNull
    private Integer alumnosMin;
    private Integer alumnosAct;
    @NotNull
    private Integer estado;

}
