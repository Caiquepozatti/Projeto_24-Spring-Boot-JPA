package com.pozatticaique.projeto24.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pozatticaique.projeto24.entities.User;
import com.pozatticaique.projeto24.repositories.UserRepository;
import com.pozatticaique.projeto24.services.exceptions.ResourceNotFound;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional (readOnly = true) //Import spring, não jakart
	public List<User> findAll(){
		List<User> result = userRepository.findAll();
		return result;
	}
	
	@Transactional (readOnly = true) //Import spring, não jakart
	public User findById(String id){
		try {
			User result = userRepository.findById(id).get();
			return result;	
		}catch(NoSuchElementException e) {
			throw new ResourceNotFound(id);
		}
	}	
	

}
