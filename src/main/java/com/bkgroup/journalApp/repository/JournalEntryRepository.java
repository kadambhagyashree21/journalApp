package com.bkgroup.journalApp.repository;

import com.bkgroup.journalApp.entity.JournalEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends CrudRepository<JournalEntry, Long> {

    public JournalEntry findJournalEntryByTitle(String title);
}
