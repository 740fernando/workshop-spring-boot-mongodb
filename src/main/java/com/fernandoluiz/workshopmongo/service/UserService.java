package com.fernandoluiz.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoluiz.workshopmongo.domain.User;
import com.fernandoluiz.workshopmongo.dto.UserDTO;
import com.fernandoluiz.workshopmongo.repository.UserRepository;
import com.fernandoluiz.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newUser = userRepository.findById(obj.getId()).get();
		updataData(newUser,obj);
		return userRepository.save(obj);
	}
	/**
	 * Responsável por copiar os dados do obj para o new Obj
	 * 
	 * obs: o ID não é alterado
	 * 
	 * @param newUser
	 * @param obj
	 */
	private void updataData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}

	/**
	 * Responsável por converter UserDTO em USER
	 * @param userDTO
	 * @return
	 */
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
	}
}
