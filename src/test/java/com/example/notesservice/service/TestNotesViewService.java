package com.example.notesservice.service;

import com.example.notesservice.dto.NoteDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestNotesViewService {

    @Mock
    NotesViewService notesViewService;

    @Test
    public void testGetNoteByIdMethod() {

        UUID uuid = UUID.randomUUID();
        List<NoteDto> notesList = notesViewService.getNoteByUUID(uuid);

        assertFalse(notesList.isEmpty());
    }
}
