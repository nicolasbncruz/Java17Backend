package edu.cibertec.sec04.dto;




public class UsuarioDTO {
   private Integer idUsuario;

   private String usuario;

   private String clave;
   private String nombreApellido;   
   private byte [] foto;
   private String fotoBase64;
	
   public UsuarioDTO() {
		
	}
   
   
   
   public UsuarioDTO(Integer idUsuario, String usuario, String clave,
			String nombreApellido, byte[] foto, String fotoBase64) {
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
	public String getFotoBase64() {
		return fotoBase64;
	}
	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
   
   
   
   
}

