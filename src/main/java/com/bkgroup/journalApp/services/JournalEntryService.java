package com.bkgroup.journalApp.services;

import com.bkgroup.journalApp.entity.JournalEntry;
import com.bkgroup.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public ResponseEntity<JournalEntry> getJournalById(Long id){
        JournalEntry journalEntry = journalEntryRepository.findById(id).orElse(null);
        if(journalEntry!=null){
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getAllJournals(){
        List<JournalEntry> all = (List<JournalEntry>) journalEntryRepository.findAll();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<JournalEntry> addJournalEntry(JournalEntry journalEntry){
        try{
            journalEntry.setCreatedDt(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(journalEntry, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<JournalEntry> updateJournalEntry(Long id, JournalEntry journalEntry){
        JournalEntry journalEntryOld = journalEntryRepository.findById(id).get();
        journalEntry.setId(id);
        journalEntry.setCreatedDt(LocalDateTime.now());
    if(journalEntryOld.getContent()!=null){
        BeanUtils.copyProperties(journalEntry,journalEntryOld);
        journalEntryRepository.save(journalEntryOld);
        return new ResponseEntity<>(journalEntryOld, HttpStatus.CREATED);
    }
        return new ResponseEntity<>(journalEntryOld, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> deleteJournalntry(Long id){
        journalEntryRepository.delete(journalEntryRepository.findById(id).get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public JournalEntry getJournalEntryByTitle(String name){
        return journalEntryRepository.findJournalEntryByTitle(name);
    }


}
