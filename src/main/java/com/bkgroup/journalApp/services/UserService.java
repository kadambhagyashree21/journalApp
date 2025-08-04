package com.bkgroup.journalApp.services;

import com.bkgroup.journalApp.entity.JournalEntry;
import com.bkgroup.journalApp.entity.User;
import com.bkgroup.journalApp.repository.JournalEntryRepository;
import com.bkgroup.journalApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Transactional
    public User addUser(User user){
        for (JournalEntry journalEntry : user.getJournalEntries()) {
            journalEntry.setUser(user);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }
}
