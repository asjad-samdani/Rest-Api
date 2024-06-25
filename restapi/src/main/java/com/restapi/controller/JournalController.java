package com.restapi.controller;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.entity.JournalEntity;

@RestController
@RequestMapping("/journal")
public class JournalController {
    private Map<Long, JournalEntity> JournalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAll() {
        return new ArrayList<>(JournalEntries.values());

    }

    @PostMapping
    public boolean createEntity(@RequestBody JournalEntity entry) {
        JournalEntries.put(entry.getId(), entry);
        return true;

    }

    @GetMapping("id/{myid}")
    public JournalEntity getJournalEntityById(@PathVariable Long myid) {
        return JournalEntries.get(myid);

    }

    @DeleteMapping("id/{myid}")
    public JournalEntity deleteJournalEntityById(@PathVariable Long myid) {
        return JournalEntries.remove(myid);

    }

    @PutMapping
    public JournalEntity updateJournalEntityById(@RequestBody JournalEntity entry, @PathVariable Long id) {
        return JournalEntries.put(id, entry);

    }

}
