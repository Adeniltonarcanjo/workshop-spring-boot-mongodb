package com.github.adeniltonarcanjo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.github.adeniltonarcanjo.workshopmongo.domain.Post;
import com.github.adeniltonarcanjo.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
