package com.develhope.nosqlorm.repositories;

import com.develhope.nosqlorm.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
