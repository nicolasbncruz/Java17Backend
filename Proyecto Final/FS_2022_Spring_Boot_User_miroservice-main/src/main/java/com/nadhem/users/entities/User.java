package com.nadhem.users.entities;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
public class User {	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long cod_usuario;

 @Column(unique=true)
	private String nombre;
	private String username;
	private String password;
	private Boolean enabled;

	@ManyToOne
	@JoinTable(name = "sucursal", joinColumns = @JoinColumn(name = "cod_usuario"),
			inverseJoinColumns = @JoinColumn(name = "cod_sucursal"))
	private Sucursal sucursal;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="cod_usuario") ,
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles;

	/*public User(String nombre, String username, String password, Boolean enabled){
		super();
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}*/
		
}
