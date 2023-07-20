package com.pozatticaique.projeto24.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pozatticaique.projeto24.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
