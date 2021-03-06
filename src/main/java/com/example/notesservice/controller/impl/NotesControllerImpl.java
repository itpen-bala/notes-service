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

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

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

/*    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE) throws EmptyFieldException {
        return ResponseEntity.ok(noteService.updateNote());
    }*/

    @DeleteMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseEntity deleteNote(@PathVariable("uuid") UUID uuid) throws DBException {
        return ResponseEntity.ok(Collections.singletonList(noteService.deleteNote(uuid)));
    }


}