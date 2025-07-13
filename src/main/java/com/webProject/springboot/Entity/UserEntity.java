package com.webProject.springboot.Entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document
@Data
public class UserEntity {
    
    @Id
    private ObjectId id;
    private String name;
    private String password;

    @DBRef
    private List<JournalEntity> journalentries = new ArrayList<>();

}
