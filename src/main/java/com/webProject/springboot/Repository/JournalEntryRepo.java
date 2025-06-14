package com.webProject.springboot.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.webProject.springboot.Entity.JournalEntity;

public interface JournalEntryRepo extends MongoRepository<JournalEntity, ObjectId> {

    
}