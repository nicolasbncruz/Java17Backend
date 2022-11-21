package com.nadhem.users;

import javax.annotation.PostConstruct;

import com.nadhem.users.entities.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.service.UserService;

@SpringBootApplication
public class UsersMicroserviceApplication {

	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	

	@PostConstruct void init_users() { //ajouter les rôles
	/*userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new	Role(null,"USER"));

	userService.addSucursal(new Sucursal(null,"Lima", null));
	userService.addSucursal(new	Sucursal(null,"Arequipa", null));*/

	//ajouter les users userService.saveUser(new
//	User(null,"admin","123",true,null));

	/*UserService.saveUser(new User(null, "Jose Morales","admin","123", true, null, null));
	UserService.saveUser(new User(null, "Nicolas Cruz","ncruz","123", true, null, null));*/

	//userService.saveUser(new User(null,"admin","123",true,null));
	//userService.saveUser(new User(null,"ncruz","123",true,null));

	//ajouter les rôles aux users userService.addRoleToUser("admin", "ADMIN");
	/*userService.addSucursalToUser("admin", "Lima");
	userService.addSucursalToUser("ncruz", "Arequipa");

	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("ncruz", "USER");*/
	}

	 
	
	@Bean
	BCryptPasswordEncoder getBCE() {
		return new BCryptPasswordEncoder();
		
	}


}
