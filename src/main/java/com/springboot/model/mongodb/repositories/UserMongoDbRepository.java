package com.springboot.model.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.model.mongodb.User;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
public interface UserMongoDbRepository extends MongoRepository<User, String>{
}
