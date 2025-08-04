package com.bkgroup.journalApp.controller;

import com.bkgroup.journalApp.entity.JournalEntry;
import com.bkgroup.journalApp.repository.JournalEntryRepository;
import com.bkgroup.journalApp.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public ResponseEntity<?> getAll(){
        return journalEntryService.getAllJournals();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> addJournalEntry(@RequestBody JournalEntry journalEntry){
        return journalEntryService.addJournalEntry(journalEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable long id){
        return journalEntryService.getJournalById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable long id, @RequestBody JournalEntry journalEntry){
        return journalEntryService.updateJournalEntry(id,journalEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJournalEntry(@PathVariable long id){
       return journalEntryService.deleteJournalntry(id);
    }

    @GetMapping("/title/{name}")
    public JournalEntry getJournalEntryById(@PathVariable String name){
        return journalEntryService.getJournalEntryByTitle(name);
    }

}
