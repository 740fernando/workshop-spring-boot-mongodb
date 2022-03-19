package com.fernandoluiz.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fernandoluiz.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	/**
	 * Consulta de titulos, ignorando CaseSensitive
	 * @param text
	 * @return
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
