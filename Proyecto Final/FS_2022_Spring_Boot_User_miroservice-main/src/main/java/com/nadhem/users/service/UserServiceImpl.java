package com.nadhem.users.service;
import com.nadhem.users.entities.Sucursal;
import com.nadhem.users.repos.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.RoleRepository;
import com.nadhem.users.repos.UserRepository;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleRepository roleRep;

	@Autowired
	SucursalRepository sucursalRep;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User user = userRep.findByUsername(username);
		Role role = roleRep.findByRole(rolename);
		user.getRoles().add(role);
		return user;
	}

	@Override
	public User addSucursalToUser(String username, String sucursalname) {
		User user = userRep.findByUsername(username);
		Sucursal sucursal = sucursalRep.findBySucursal(sucursalname);
		user.setSucursal(sucursal);
		return user;
	}

	@Override
	public User getUser(Long id) {
		return userRep.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRep.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRep.findAll();
	}

	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public Sucursal addSucursal(Sucursal sucursal) {
		return sucursalRep.save(sucursal);
	}


	@Override
	public User findUserByUsername(String username) {	
		return userRep.findByUsername(username);
	}

	@Override
	public void deleteUserById(Long id) {
		userRep.deleteById(id);
	}

}
