package com.webProject.springboot.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webProject.springboot.Entity.JournalEntity;
import com.webProject.springboot.Repository.JournalEntryRepo;

@Component
public class JournalEntryServices {

    @Autowired
    private JournalEntryRepo jerepo;

    public void saveEntry(JournalEntity je){
        jerepo.save(je);
    }

    public List<JournalEntity> getAll(){
        return jerepo.findAll();
    }

    public Optional<JournalEntity> findById(ObjectId obj){
        return jerepo.findById(obj);
    }

    public void deleteById(ObjectId obj){
        jerepo.deleteById(obj);
    }     
}