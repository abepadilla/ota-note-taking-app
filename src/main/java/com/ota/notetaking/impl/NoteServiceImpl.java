package com.ota.notetaking.impl;

import com.ota.notetaking.dto.NoteDto;
import com.ota.notetaking.impl.service.NoteService;
import com.ota.notetaking.model.Note;
import com.ota.notetaking.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void saveNote(NoteDto request) {
        log.info("Note starting to save...");

        Note note = Note.builder()
                .title(request.getTitle()).body(request.getBody()).build();
        noteRepository.save(note);
        log.info("Note saved successfully!");
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<NoteDto> response = new ArrayList<>();
        List<Note> notes = noteRepository.findAll();
        for (Note n : notes) {
            response.add(mapToDto(n));
        }
        return response;
    }

    @Override
    public NoteDto getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new RuntimeException("Unable to retrieve data based on your request.");
        }
        return mapToDto(note.get());
    }

    @Override
    @Transactional
    public NoteDto updateNoteById(Long id, NoteDto request) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new RuntimeException("No data found to update.");
        }
        noteRepository.updateNoteById(request.getTitle(), request.getBody(), request.getId());
        log.info("Note with title '{}' was updated.", request.getTitle());
        return request;
    }

    @Override
    public void deleteNoteById(Long id) {
        log.info("Deleting note # {}...", id);
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new RuntimeException("Unable to delete. No data found.");
        }
        log.info("Note deleted successfully.");
        noteRepository.deleteById(id);
    }

    private NoteDto mapToDto(Note note) {
        return NoteDto.builder().id(note.getId()).title(note.getTitle()).body(note.getBody()).build();
    }
}
