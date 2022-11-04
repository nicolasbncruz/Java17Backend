package edu.cibertec.matricula.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author jpere
 */
@Data
@Entity
@Table(name = "auditoria")
public class AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idauditoria")
    private Integer idAuditoria; 
    
    @Column(name="fechahora", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora; 
    
    @OneToOne
    @JoinColumn(name = "idusuario",updatable = false, nullable = false)
    private UsuarioEntity usuario; 
    
    @Column(name="operacion", nullable = false)
    private String operacion;
}
