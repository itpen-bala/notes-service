package com.example.notesservice.controller.impl;

import com.example.notesservice.constants.RequestPath;
import com.example.notesservice.controller.NotesController;
import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.model.Note;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController(RequestPath.NOTES_SERVICE_PATH)
@RequiredArgsConstructor
@Slf4j
public class NotesController implements NotesController {

    @PostMapping
    ResponseEntity addNote(@RequestBody NoteDto noteDto) {

        return
    }

    //TODO: UPDATE

    @DeleteMapping("/{uuid}")
    ResponseEntity deleteNote(@PathVariable("uuid") UUID uuid) throws DBException;


}