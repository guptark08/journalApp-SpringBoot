package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

//    CRUD - Create, Read, Update, Delete

    // Create
    @PostMapping
    public boolean createJournalEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    //Read
    @GetMapping     //locahlhost:8080/journal   GET
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    //Read by ID
    @GetMapping("/id/{myId}")
    public JournalEntry getById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }

    //Update by ID
    @PutMapping("/id/{myId}")
    public boolean updateJournalEntry(@PathVariable long myId, @RequestBody JournalEntry myEntry) {
        journalEntries.put(myId, myEntry);
        return true;
    }

    //Delete by ID
    @DeleteMapping("/id/{myId}")
    public JournalEntry DeleteJournalEntry(@PathVariable long myId) {
        return journalEntries.remove(myId);
    }



}
