package com.assignment.userresource;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
	
	List<User> findByEmail(String email);
	
	@Query(value = "{'month': {$regex : ?0, $options: 'i'}}")
	List<User> findByMonth(String month);
	
}
