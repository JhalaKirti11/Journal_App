package com.webProject.springboot.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.webProject.springboot.Entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {

    UserEntity findByName(String name);
}