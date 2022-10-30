package edu.cibertec.entity;


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
import javax.validation.constraints.NotNull;
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
    private Integer idAuditoria; 
    
    @NotNull
    @Column(name="fechahora", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora; 
    
    @OneToOne
    @JoinColumn(name = "idUsuario",updatable = false, nullable = false)
    private UsuarioEntity usuario; 
    @Column(nullable = false)
    private String operacion;
}
