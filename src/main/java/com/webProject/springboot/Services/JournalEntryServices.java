package com.webProject.springboot.Services;

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

     
}