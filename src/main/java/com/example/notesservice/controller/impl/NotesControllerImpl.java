package com.example.notesservice.controller.impl;

import com.example.notesservice.constants.RequestPath;
import com.example.notesservice.controller.NotesController;
import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.exceptions.EmptyFieldException;
import com.example.notesservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController(RequestPath.NOTES_SERVICE_PATH)
@RequiredArgsConstructor
@Slf4j
public class NotesControllerImpl implements NotesController {

    private final NoteService noteService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseEntity addNote(@RequestBody NoteDto noteDto) throws EmptyFieldException {
        return ResponseEntity.ok(noteService.addNote(noteDto));
    }

    @PostMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseEntity updateNote(@PathVariable("uuid") UUID uuid, @RequestBody Map<String, String> text) throws DBException {
        return ResponseEntity.ok(noteService.updateNote(uuid, text));
    }

    @DeleteMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseEntity deleteNote(@PathVariable("uuid") UUID uuid) throws DBException {
        return ResponseEntity.ok(Collections.singletonList(noteService.deleteNote(uuid)));
    }


}