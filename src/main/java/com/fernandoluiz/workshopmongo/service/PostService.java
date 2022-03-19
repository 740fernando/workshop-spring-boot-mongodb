package com.fernandoluiz.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoluiz.workshopmongo.domain.Post;
import com.fernandoluiz.workshopmongo.repository.PostRepository;
import com.fernandoluiz.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Post user = postRepository.findById(id).get();
		if(user == null) {
			throw new ObjectNotFoundException("Objecto não encontrado");
		}
		return user;
	}
	public List<Post> findByTitle(String text){
		//return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.searchTitle(text);
	}
}
