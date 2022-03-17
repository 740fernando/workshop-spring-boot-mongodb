package com.fernandoluiz.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
		User obj = userService.fromDTO(userDTO);
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Boa prática - Retorna uma resposta vazia com header do novo recurso criado;
		return ResponseEntity.created(uri).build(); //created(uri) -> retorna com código 201
	}

}
// ResponseEntity - Objeto sofisticado do spring. Contem atributos específicos do HTTP. ex: Header, body e error.