package com.fernandoluiz.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoluiz.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET) // outro modo seria colocando @GetMapping
	public ResponseEntity<List<User>> findAll() {
		User fernando = new User("1", "Fernando", "fernando@gmail.com");
		User lauren = new User("1", "Lauren", "lauren@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(fernando, lauren));
		return ResponseEntity.ok().body(list);
	}

}
// ResponseEntity - Objeto sofisticado do spring. Contem atributos específicos do HTTP. ex: Header, body e error.