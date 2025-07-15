package com.webProject.springboot.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webProject.springboot.Entity.JournalEntity;
import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Services.JournalEntryServices;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryServices jeserve;
    @Autowired
    private UserEntity userAdmin;

    // private Map<ObjectId, JournalEntity> jeObj = new HashMap<>();

    // Get All Journal Entries
    @GetMapping("{user}")
    public ResponseEntity<?> getJournalOfUser(@PathVariable String user){
        UserEntity user2 = userAdmin.findByName(user);
        if(user2 != null){
            List<JournalEntity> allEntries = user2.getJournalentries();
            if(allEntries != null && !allEntries.isEmpty()){
                return new ResponseEntity<>(allEntries, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Post A Journal Entry
    @PostMapping
    public ResponseEntity<JournalEntity> postJournal(@RequestBody JournalEntity obj) {
        try {
            // jeObj.put(obj.getId(), obj);
            obj.setDate(LocalDateTime.now());
            jeserve.saveEntry(obj);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get Specific Journal Entry
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntity> getSpecificEntity(@PathVariable ObjectId myId) {
        Optional<JournalEntity> res = jeserve.findById(myId);
        if (res.isPresent()) {
            return new ResponseEntity<>(res.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId) {
        boolean res = jeserve.deleteById(myId);
        if (res) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateAnEntry(@PathVariable ObjectId myId, @RequestBody JournalEntity newObj) {
        JournalEntity old = jeserve.findById(myId).orElse(null);
        System.out.println("Find out the old bean : " + old);
        if (old != null) {
            old.setTitle(newObj.getTitle() != null && newObj.getTitle() != "" ? newObj.getTitle() : old.getTitle());
            old.setContent(
                    newObj.getContent() != null && newObj.getContent() != "" ? newObj.getContent() : old.getContent());
            jeserve.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
