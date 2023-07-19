package com.pozatticaique.projeto24.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pozatticaique.projeto24.DTOs.UserDTO;
import com.pozatticaique.projeto24.entities.User;
import com.pozatticaique.projeto24.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> result = userService.findAll();
		List<UserDTO> dto = result.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(dto);		
	}	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <UserDTO> findByID(@PathVariable String id){		
		User result = userService.findById(id);
		UserDTO dto = new UserDTO(result);
		return ResponseEntity.ok().body(dto);		
	}
}
