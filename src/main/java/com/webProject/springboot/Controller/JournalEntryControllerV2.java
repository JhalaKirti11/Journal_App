package com.webProject.springboot.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webProject.springboot.Entity.JournalEntity;
import com.webProject.springboot.Services.JournalEntryServices;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryServices jeserve;

    // private Map<ObjectId, JournalEntity> jeObj = new HashMap<>();

    // Get All Journal Entries
    @GetMapping
    public List<JournalEntity> getJournal() {
        return jeserve.getAll();
    }

    // Post A Journal Entry
    @PostMapping
    public boolean postJournal(@RequestBody JournalEntity obj) {
        // jeObj.put(obj.getId(), obj);
        obj.setDate(LocalDateTime.now());
        jeserve.saveEntry(obj);
        return true;
    }

    // Get Specific Journal Entry
    @GetMapping("id/{myId}")
    public JournalEntity getSpecificEntity(@PathVariable ObjectId myId) {
        return jeserve.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId) {
        jeserve.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntity updateAnEntry(@PathVariable ObjectId myId, @RequestBody JournalEntity newObj) {
        JournalEntity old = jeserve.findById(myId).orElse(null);
        System.out.println("Find out the old bean : "+ old);
        if (old != null) {
            old.setTitle(newObj.getTitle() != null && newObj.getTitle() != "" ? newObj.getTitle() : old.getTitle());
            old.setContent(
                    newObj.getContent() != null && newObj.getContent()!= "" ? newObj.getContent() : old.getContent());
        }
        System.out.println("updated");
        jeserve.saveEntry(old);
        System.out.println("yes "+old);
        return old;
    }
}
