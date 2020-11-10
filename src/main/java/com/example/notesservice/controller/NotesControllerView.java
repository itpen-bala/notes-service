package com.example.notesservice.controller;

import com.example.notesservice.constants.RequestPathes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(RequestPathes.NOTES_SERVICE_VIEW_PATH)
public interface NotesControllerView {

    public ResponseEntity getNoteByUUID(@PathVariable("uuid") UUID uuid);
    //public Note getNote(@PathVariable("uuid") UUID uuid);
}
