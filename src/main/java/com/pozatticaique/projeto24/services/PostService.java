package com.pozatticaique.projeto24.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pozatticaique.projeto24.entities.Post;
import com.pozatticaique.projeto24.repositories.PostRepository;
import com.pozatticaique.projeto24.services.exceptions.ObjectNotFoundException;

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
			throw new ObjectNotFoundException(id);
		}
	}	
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}	
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		return  postRepository.fullSearch(text, minDate, maxDate);
	}
}
