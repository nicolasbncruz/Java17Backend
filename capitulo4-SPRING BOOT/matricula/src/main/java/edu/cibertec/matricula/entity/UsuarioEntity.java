package edu.cibertec.matricula.entity;

import java.io.Serializable;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author jpere
 */
@Data
@Entity
@Table(name = "usuario")
//@XmlRootElement
public class UsuarioEntity implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer idUsuario;

    @NotEmpty(message = "Estimado usuario este campo es obligatorio")
    @Size(min=3,max=30, message = "Estimado usuario debe de ingresar minimo 3 caracteres y maximo 30")
    @Column(name="usuario", nullable = false)
    private String usuario;
    
    @NotEmpty(message = "Estimado usuario este campo es obligatorio")
    @Column(name="clave", nullable = false)
    private String clave;
    
    @Column(name="nombreapellido", nullable = false)
    private String nombreApellido;
    
    
    @Column(name="estado", nullable = true)
    private String estado;
    
    @Column(name="sexo", nullable = true)
    private String sexo;
    
    @Column(name="foto", nullable = true)
    private byte[] foto;
    
    
    
    @Transient
    private String fotoBase64;   
    
    public String  getFotoBase64(){
         String valor=null;
         if(foto!=null&&foto.length>0){
             valor=Base64.getEncoder().encodeToString(foto);
         }
         return valor;
    }
}
