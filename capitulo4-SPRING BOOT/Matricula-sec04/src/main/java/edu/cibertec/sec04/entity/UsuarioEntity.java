package edu.cibertec.sec04.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = -3381308822419928290L;
	@Id
    //PARA MYSQL
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    //PARA VARIAS BD
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native") --> El más genérico para bd relacionales
    @Column(name = "idusuario")
	private Integer idUsuario;

	@NotNull(message = "El usuario debe es un argumento requerido")
    private String usuario;
    
    @NotNull(message = "La clave es un argumento requerido")
    @NotEmpty
    @Size(min = 3, max = 12)
    private String clave;
    
    @NotNull(message = "El Nombre debe es un argumento requerido")
    @Column(name = "nombreapellido")
    private String nombreApellido;

    @Column(nullable = true)
    private byte[] foto;
    
    @Transient
    private String fotoBase64;

    public UsuarioEntity() {
		
	}
    
    
    
	public UsuarioEntity(Integer idUsuario, String usuario, String clave, String nombreApellido, byte[] foto,
			String fotoBase64) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = clave;
		this.nombreApellido = nombreApellido;
		this.foto = foto;
		this.fotoBase64 = fotoBase64;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String  getFotoBase64(){
        String valor=null;
        if(foto!=null&&foto.length>0){
            valor=Base64.getEncoder().encodeToString(foto);
        }
        return valor;
   }


	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave
				+ ", nombreApellido=" + nombreApellido + ", foto=" + Arrays.toString(foto) + ", fotoBase64="
				+ fotoBase64 + "]";
	}
    
    
}
