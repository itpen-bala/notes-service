package com.example.notesservice.controller;

import com.example.notesservice.constants.Constants;
import com.example.notesservice.model.Note;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(Constants.NOTES_SERVICE_VIEW_PATH)
public interface NotesControllerView {

    public Note getNote(@PathVariable("uuid") UUID uuid);
}
