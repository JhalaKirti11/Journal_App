package com.webProject.springboot.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webProject.springboot.Entity.JournalEntity;
import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Repository.JournalEntryRepo;

import jakarta.transaction.Transactional;

@Component

public class JournalEntryServices {

    @Autowired
    private JournalEntryRepo jerepo;
    @Autowired
    private UserService user_repo;

    @Transactional
    public void saveEntry(JournalEntity je, String username) {
        try {
            UserEntity user = user_repo.findByName(username);
            je.setDate(LocalDateTime.now());
            JournalEntity saved = jerepo.save(je);
            user.getJournalentries().add(saved);
            // user.setName(null);
            user_repo.saveUser(user);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }

    public List<JournalEntity> getAll() {
        return jerepo.findAll();
    }

    public Optional<JournalEntity> findById(ObjectId obj) {
        return jerepo.findById(obj);
    }

    public boolean deleteById(ObjectId obj, String name) {
        UserEntity user = user_repo.findByName(name);
        if (user != null) {
            jerepo.deleteById(obj);
            user.getJournalentries().removeIf(x -> x.getId().equals(obj));
            user_repo.saveUser(user);
        }
        return true;
    }
}