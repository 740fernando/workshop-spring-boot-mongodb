package com.fernandoluiz.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoluiz.workshopmongo.domain.User;
import com.fernandoluiz.workshopmongo.dto.UserDTO;
import com.fernandoluiz.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET) // outra definição com o mesmo objetivo  seria colocando @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
// ResponseEntity - Objeto sofisticado do spring. Contem atributos específicos do HTTP. ex: Header, body e error.