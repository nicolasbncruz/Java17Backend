package edu.cibertec.sec04.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jpere
 */
@Entity
@Table(name = "curso")
@NamedQuery(name = "CursoEntity.abiertoIncompleto", query = "SELECT c FROM CursoEntity c WHERE c.alumnosMin>c.alumnosAct AND c.estado=1")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    
    @Column(name = "nomcurso", nullable = false)
    private String nomCurso;
    
    @Column(name = "fechainicio", nullable = false)
    private Date fechaInicio;
    
    @Column(name = "alumnosmin", nullable = false)
    private Integer alumnosMin;
    
    @Column(name = "alumnosact", nullable = false)
    private Integer alumnosAct;
    
    @Column(name = "estado")
    private Integer estado;
    
    
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomCurso() {
		return nomCurso;
	}
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Integer getAlumnosMin() {
		return alumnosMin;
	}
	public void setAlumnosMin(Integer alumnosMin) {
		this.alumnosMin = alumnosMin;
	}
	public Integer getAlumnosAct() {
		return alumnosAct;
	}
	public void setAlumnosAct(Integer alumnosAct) {
		this.alumnosAct = alumnosAct;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
    
    
    
}
