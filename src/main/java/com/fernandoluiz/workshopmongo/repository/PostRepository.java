package com.fernandoluiz.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fernandoluiz.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	/**
	 * Consulta de titulos, utilizando a anotacao.
	 *
	 * Query - Permite realizar a consulta na forma de texto json
	 *
	 * @param text
	 * @return
	 */
	@Query("{ 'title' : { $regex: ?0 $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	/**
	 * Consulta de titulos utilizando metodo nativo do Spring Data - MongoDB Repositories, ignorando CaseSensitive
	 * Obs : Padrao de nomenclatura obrigatorio
	 * <b>Ref: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories</b>
	 * @param String
	 * @return List<Post>
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [{date: {$gte: ?1}}, { date: { $lte: ?2 }} , { $or: [ { 'title' : { $regex: ?0 $options: 'i' } }, { 'body' : { $regex: ?0 $options: 'i' } }, { 'comments.text' : { $regex: ?0 $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
