package com.example.notesservice.service;

import com.example.notesservice.dto.NoteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class NotesViewService {

    public List<NoteDto> getNoteByUUID(UUID uuid) {
        return new ResponseEntity(HttpStatus.OK);
    }
}