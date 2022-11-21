package com.nadhem.users.service;

import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.Sucursal;
import com.nadhem.users.entities.User;

import java.util.List;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	Sucursal addSucursal(Sucursal sucursal);
	User addRoleToUser(String username, String rolename);
	User addSucursalToUser(String username, String sucursalname);

	User getUser(Long id);

	User updateUser(User user);

	List<User> getAllUsers();

	void deleteUserById(Long id);
}
