package com.webProject.springboot.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.webProject.springboot.Entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity, ObjectId>{

}