package edu.cibertec.matricula.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @Column(name="idcurso")
    private Integer idCurso;
    @Column(name="nomcurso", nullable = false)
    private String nomCurso;
    @Column(name="fechainicio", nullable = false)
    private Date fechaInicio;
    @Column(name="alumnosmin", nullable = false)
    private Integer alumnosMin;
    private Integer alumnosAct;
    @Column(name="estado", nullable = false)
    private Integer estado;

}
