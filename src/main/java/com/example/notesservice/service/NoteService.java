package com.example.notesservice.service;

import com.example.notesservice.dto.NoteDto;
import com.example.notesservice.exceptions.DBException;
import com.example.notesservice.exceptions.EmptyFieldException;
import com.example.notesservice.model.Note;
import com.example.notesservice.repository.NoteDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class NoteService {

    private final NoteDao noteDao;

    public NoteDto addNote(NoteDto noteDto) throws EmptyFieldException {

        checkDto(noteDto);
        final Note note = mapToNote(noteDto);

        return mapToNoteDto(noteDao.addNote(note));
    }

    public UUID updateNote(UUID uuid, Map<String, String> text) throws DBException {

        if(!noteDao.existNote(uuid)) {
            throw new DBException("There is no note " + uuid + " in the database");
        }

        noteDao.updateNote(uuid, text.get("text"));
        return uuid;
    }

    public UUID deleteNote(UUID uuid) throws DBException {

        if(!noteDao.existNote(uuid)) {
            throw new DBException("There is no note " + uuid + " in the database");
        }

        noteDao.deleteNote(uuid);
        return uuid;
    }

    private Note mapToNote(NoteDto noteDto) {

        return Note.builder()
                .uuid(noteDto.getUuid())
                .date(noteDto.getDate())
                .author(noteDto.getAuthor())
                .text(noteDto.getText())
                .build();
    }

    private NoteDto mapToNoteDto(Note note) {

        return new NoteDto()
                .setUuid(note.getUuid())
                .setDate(note.getDate())
                .setAuthor(note.getAuthor())
                .setText(note.getText());
    }

    private void checkDto(NoteDto noteDto) throws EmptyFieldException {

        if(StringUtils.isEmpty(noteDto.getUuid())) {
            throw new EmptyFieldException("Field \"UUID\" must not be empty");
        }

        if(StringUtils.isEmpty(noteDto.getDate())) {
            throw new EmptyFieldException("Field \"Date\" must not be empty");
        }

        if(StringUtils.isEmpty(noteDto.getAuthor())) {
            throw new EmptyFieldException("Field \"Author\" must not be empty");
        }
    }
}
