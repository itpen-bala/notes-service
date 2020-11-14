package com.example.notesservice.service;

import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.model.Note;
import com.example.notesservice.repository.NoteViewDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotesViewService {

    public final NoteViewDao noteViewDao;

    public List<NoteDto> getNoteByUUID(UUID uuid) throws DBException {

        if (!noteViewDao.existNote(uuid)) {
            throw new DBException("There is no note with this uuid in the database: " + uuid.toString());
        }

        return noteViewDao.getNoteByUUID(uuid)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private NoteDto mapToDto (Note note) {
        return new NoteDto()
                .setUuid(note.getUuid())
                .setDate(note.getDate())
                .setAuthor(note.getAuthor())
                .setText(note.getText());
    }
}