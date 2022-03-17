package com.fernandoluiz.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fernandoluiz.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
}
