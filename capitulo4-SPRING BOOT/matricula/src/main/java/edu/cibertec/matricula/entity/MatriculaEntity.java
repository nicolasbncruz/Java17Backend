package edu.cibertec.matricula.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jpere
 */
@Data
@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmatricula")
    private Integer idMatricula; 

    @Column(name="fechamat", nullable = false)
    private Date fechaMat; 
    @OneToOne
    @JoinColumn(name = "idusuario",updatable = false, nullable = false)
    private UsuarioEntity usuario; 
    @OneToOne
    @JoinColumn(name = "idcurso",updatable = false, nullable = false)
    private CursoEntity curso;
    @Column(name="estado", nullable = true)
    private Integer estado;

}
