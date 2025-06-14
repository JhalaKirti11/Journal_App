package com.webProject.springboot.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // private Map<Long, JournalEntity> jeObj = new HashMap<>();

    // Get All Journal Entries
    @GetMapping
    public List<JournalEntity> getJournal(){
        return null;
    }

    // Post A Journal Entry
    @PostMapping
    public boolean postJournal(@RequestBody JournalEntity obj){
        // jeObj.put(obj.getId(), obj);
        jeserve.saveEntry(obj);
        return true;
    }

    // Get Specific Journal Entry
    @GetMapping("id/{myId}")
    public JournalEntity getSpecificEntity(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntity deleteEntry(@PathVariable Long myId){
        return null;
    }

    @PutMapping("id/{myId}")
    public JournalEntity updateAnEntry(@PathVariable Long myId, @RequestBody JournalEntity obj ){
        return null;
    }
}
