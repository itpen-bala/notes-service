package com.example.notesservice.controller.impl;

import com.example.notesservice.constants.Constants;
import com.example.notesservice.controller.NotesControllerView;
import com.example.notesservice.model.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController(Constants.NOTES_SERVICE_VIEW_PATH)
public class NotesControllerViewImpl implements NotesControllerView {

    private final Date date = new Date();

    @GetMapping("/{uuid}")
    public Note getNote(@PathVariable("uuid") UUID uuid) {
        return new Note(uuid, date, "Victor", "HELLO!");
    }

}
