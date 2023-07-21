package com.pozatticaique.projeto24.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pozatticaique.projeto24.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//Consulta simples com Query methods
	//https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	//https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	List<Post> findByTitleContainingIgnoreCase(String text); //Igonorar letras maiusculas
	
	//Consulta com @Query
	//https://docs.mongodb.com/manual/reference/operator/query/regex/
	@Query("{'title': { $regex: ?0, $options: 'i'} }")//Pegar como parametro a String text (?0), (Options = i) == IgonreCase
	List<Post> searchTitle(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
