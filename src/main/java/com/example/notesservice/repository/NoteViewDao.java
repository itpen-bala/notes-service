package com.example.notesservice.repository;

import com.example.notesservice.constants.SQLQueries;
import com.example.notesservice.model.Note;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
@RequiredArgsConstructor
public class NoteViewDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String checkIsExistNote = SQLQueries.IS_EXIST_NOTE;
    private String selectNoteByUUID = SQLQueries.SELECT_NOTE_BY_UUID;

    public List<Note> getNoteByUUID(UUID uuid) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", uuid);

        return namedParameterJdbcTemplate.query(selectNoteByUUID, parameter, rowMapper());
    }

    private RowMapper<Note> rowMapper() {

        return (rs, rowNum) -> Note.builder()
                .uuid(UUID.fromString(rs.getString("uuid")))
                .date(rs.getString("date"))
                .author(rs.getString("author"))
                .text(rs.getString("text"))
                .build();
    }

    public boolean existNote(UUID uuid) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", uuid);

        return namedParameterJdbcTemplate.query(checkIsExistNote, parameter, isExistMapper()).get(0);
    }

    private RowMapper<Boolean> isExistMapper() { return (rs, rowNUm) -> rs.getBoolean("is_exist"); }
}
