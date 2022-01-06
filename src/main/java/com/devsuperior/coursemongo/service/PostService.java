package com.devsuperior.coursemongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.coursemongo.models.dto.PostDTO;
import com.devsuperior.coursemongo.models.entities.Post;
import com.devsuperior.coursemongo.repositories.PostRepository;
import com.devsuperior.coursemongo.service.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public PostDTO findById(String id) {
		Post entity = getEntityById(id);	
		return new PostDTO(entity);
	}

	private Post getEntityById(String id) {
		Optional<Post> result = repository.findById(id);
		return result.orElseThrow(()-> new ResourceNotFoundException("Obj não encontrado!"));
	}
}
