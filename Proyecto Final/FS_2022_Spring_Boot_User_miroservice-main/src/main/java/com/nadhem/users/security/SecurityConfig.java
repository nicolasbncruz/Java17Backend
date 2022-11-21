package com.nadhem.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 	@Autowired
 	UserDetailsService userDetailsService;
 	
 	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	
    }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	  http.sessionManagement().
	  			sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http.authorizeRequests().antMatchers("/login").permitAll();  
	  http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN");

		//consultar todos los usuarios
		http.authorizeRequests().antMatchers("/usuarios/all/**").hasAnyAuthority("ADMIN","USER");

		//consultar un uasurio
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/usuarios/**").hasAnyAuthority("ADMIN","USER");

		//agregar un nuevo usuario
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/usuarios/**").hasAuthority("ADMIN");

		//modificar un usuario
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/usuarios/**").hasAuthority("ADMIN");

		//eliminar un usuario
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/usuarios/**").hasAuthority("ADMIN");

	  http.authorizeRequests().anyRequest().authenticated();
	  http.addFilter(new  JWTAuthenticationFilter (authenticationManager())) ;
	  http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

		 
  }

}
