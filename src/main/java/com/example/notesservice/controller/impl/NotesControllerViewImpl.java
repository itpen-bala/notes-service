package com.example.notesservice.controller.impl;

import com.example.notesservice.constants.RequestPath;
import com.example.notesservice.controller.NotesControllerView;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.service.NotesViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(RequestPath.NOTES_SERVICE_VIEW_PATH)
@RequiredArgsConstructor
public class NotesControllerViewImpl implements NotesControllerView {

    private final NotesViewService notesViewService;

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseEntity getNoteByUUID(@PathVariable("uuid") UUID uuid) throws DBException {
        return ResponseEntity.ok(notesViewService.getNoteByUUID(uuid));
    }

}
