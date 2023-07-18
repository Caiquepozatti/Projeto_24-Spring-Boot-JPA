package com.pozatticaique.projeto24.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pozatticaique.projeto24.entities.User;
import com.pozatticaique.projeto24.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll(){
		List<User> result = userService.findAll();
		return result;		
	}	
}
