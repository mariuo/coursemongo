package com.devsuperior.coursemongo.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.coursemongo.models.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'title' : { $regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	@Query("{ $and: [ { 'moment': {$gte: ?1}}, { 'moment': {$lte: ?2}} , "
			+ "{ $or: [ {'title' : { $regex: ?0, $options: 'i'}}, {'body' : { $regex: ?0, $options: 'i'}}, {'comments.text' : { $regex: ?0, $options: 'i'}} ] } ] }")
	List<Post> fullSearch(String text, Instant startMoment, Instant endMoment);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}

// { $and: [ {<expression1> }, { <expression2> } ,... ,{ <expressionN> } ] }
// { field: { $gte: value } }
// { field: { $lte: value } }

// {moment: {$gte: ?1}}
// {moment: {$lte: ?2}}
// {'title' : { $regex: ?0, $options: 'i'}}
// {'body' : { $regex: ?0, $options: 'i'}}
// {'comments.text' : { $regex: ?0, $options: 'i'}}

// { $or: [ { <expression1> }, { <expression2> }, ... , { <expressionN> } ] }

// { $or: [ {'title' : { $regex: ?0, $options: 'i'}}, {'body' : { $regex: ?0, $options: 'i'}}, {'comments.text' : { $regex: ?0, $options: 'i'}} ] }


// { $and: [ {moment: {$gte: ?1}, {moment: {$gte: ?2}} , { $or: [ {'title' : { $regex: ?0, $options: 'i'}}, {'body' : { $regex: ?0, $options: 'i'}}, {'comments.text' : { $regex: ?0, $options: 'i'}} ] } ] }
