package com.pozatticaique.projeto24.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pozatticaique.projeto24.entities.Post;
import com.pozatticaique.projeto24.repositories.PostRepository;
import com.pozatticaique.projeto24.services.exceptions.ResourceNotFound;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;	
	
	@Transactional (readOnly = true) //Import spring, não jakart
	public Post findById(String id){
		try {
			Post result = postRepository.findById(id).get();
			return result;	
		}catch(NoSuchElementException e) {
			throw new ResourceNotFound(id);
		}
	}	
}
