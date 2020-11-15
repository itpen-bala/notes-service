package com.example.notesservice.controller;

import com.example.notesservice.constants.RequestPath;
import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.exceptions.EmptyFieldException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(RequestPath.NOTES_SERVICE_PATH)
public interface NotesController {

    @PostMapping
    ResponseEntity addNote(@RequestBody NoteDto noteDto) throws EmptyFieldException;

    //TODO: UPDATE

    @DeleteMapping("/{uuid}")
    ResponseEntity deleteNote(@PathVariable("uuid")UUID uuid) throws DBException;
}
