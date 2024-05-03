package com.ota.notetaking.impl.service;

import com.ota.notetaking.dto.NoteDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteService {

    public void saveNote(NoteDto request);
    public List<NoteDto> getAllNotes();
    public NoteDto getNoteById(Long id);
    public NoteDto updateNoteById(Long id, NoteDto request);
    public void deleteNoteById(Long id);


}
