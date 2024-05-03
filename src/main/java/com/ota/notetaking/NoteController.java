package com.ota.notetaking;


import com.ota.notetaking.dto.NoteDto;
import com.ota.notetaking.impl.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping(value = "/notes")
    public String createNote(@RequestBody NoteDto request) {
        log.info("Request received.");
        noteService.saveNote(request);
        return "Note is saved.";
    }

    @GetMapping("/notes")
    public List<NoteDto> getAllNotes() {
        log.info("Retrieving all notes.");
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public NoteDto getNoteById(@PathVariable("id") Long id) {
        log.info("Retrieving Note # {}.", id);
        return noteService.getNoteById(id);
    }

    @PutMapping("/notes/{id}")
    public NoteDto updateNoteById(@PathVariable("id") Long id, @RequestBody NoteDto request) {
        log.info("Updating note # {}", id);
        return noteService.updateNoteById(id, request);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNoteById(@PathVariable("id") Long id) {
        log.info("Processing request of deletion...");
        noteService.deleteNoteById(id);
    }

}
