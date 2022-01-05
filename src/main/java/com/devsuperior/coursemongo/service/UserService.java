package com.devsuperior.coursemongo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.coursemongo.models.dto.UserDTO;
import com.devsuperior.coursemongo.models.entities.User;
import com.devsuperior.coursemongo.repositories.UserRepository;
import com.devsuperior.coursemongo.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
	}
	
	public UserDTO findById(String id) {
		Optional<User> result = repository.findById(id);
		User entity = result.orElseThrow(()-> new ResourceNotFoundException("Obj não encontrado!"));
		return new UserDTO(entity);
	}
}
