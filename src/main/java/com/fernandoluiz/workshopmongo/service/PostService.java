package com.fernandoluiz.workshopmongo.service;

import java.util.Date;
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
	/**
	 * Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou comentários) e em um dado
intervalo de datas"
	 * obs: Se eu quero buscar um post até o final de uma determianda data é necessário acrescetar mais 24 horas.
	 * @param text
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime()+ 24 * 60 * 60 * 1000); // Converte a data maxima para milisegundo com o getTime e soma mais 24 horas
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
