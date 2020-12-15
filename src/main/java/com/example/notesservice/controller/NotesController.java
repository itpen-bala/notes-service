package com.example.notesservice.controller;

import com.example.notesservice.constants.RequestPath;
import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.exceptions.EmptyFieldException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping(RequestPath.NOTES_SERVICE_PATH)
public interface NotesController {

    @PostMapping
    ResponseEntity addNote(@RequestBody NoteDto noteDto) throws EmptyFieldException;

    @PostMapping("/{id}")
    ResponseEntity updateNote(@PathVariable("uuid") UUID uuid, @RequestBody Map<String, String> text) throws DBException;

    @DeleteMapping("/{uuid}")
    ResponseEntity deleteNote(@PathVariable("uuid") UUID uuid) throws DBException;
}
