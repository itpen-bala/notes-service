package com.example.notesservice.repository;

import com.example.notesservice.constants.SQLQueries;
import com.example.notesservice.model.Note;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@Slf4j
@RequiredArgsConstructor
public class NoteViewDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

    private String selectNoteByUUID = SQLQueries.SELECT_NOTE_BY_UUID;

    public List<Note> getNoteByUUID(UUID uuid) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", uuid);

        return namedParameterJdbcTemplate.query(String.format(selectNoteByUUID, uuid), parameter, rowMap());
    }

    private RowMapper<Note> rowMap() {
        return (rs, rowNum) -> Note.builder();
    }

}
