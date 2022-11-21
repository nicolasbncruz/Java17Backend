package com.nadhem.users.restControllers;

import java.util.List;

import com.nadhem.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.UserRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UserRestController {

	@Autowired
	UserService userService;
	
	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	 }

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User produit) {
		return userService.saveUser(produit);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User updateProduit(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id)
	{
		userService.deleteUserById(id);
	}

}
