package com.devsuperior.coursemongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.coursemongo.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
