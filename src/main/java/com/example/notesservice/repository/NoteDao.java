package com.example.notesservice.repository;

import com.example.notesservice.constants.SQLQueries;
import com.example.notesservice.model.Note;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@Slf4j
@RequiredArgsConstructor
public class NoteDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String checkIsExistNote = SQLQueries.IS_EXIST_NOTE;
    private final String addNote = SQLQueries.INSERT_NOTE;
    private final String updateNote = SQLQueries.UPDATE_NOTE;
    private final String deleteNote = SQLQueries.DELETE_NOTE_BY_UUID;

    @Transactional
    public Note addNote(Note note) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", note.getUuid());
        parameter.put("date", note.getDate());
        parameter.put("author", note.getAuthor());
        parameter.put("text", note.getText());

        final List<Note> result = namedParameterJdbcTemplate.query(addNote, parameter, getRowMapper());

        return result.get(0);
    }

    @Transactional
    public void updateNote(UUID uuid, String text) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", uuid);
        parameter.put("text", text);

        namedParameterJdbcTemplate.update(updateNote, parameter);
    }

    @Transactional
    public void deleteNote(UUID uuid) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", uuid);

        namedParameterJdbcTemplate.update(deleteNote, parameter);
    }

    private RowMapper<Note> getRowMapper() {

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

    private RowMapper<Boolean> isExistMapper() { return (rs, rowNum) -> rs.getBoolean("is_exist"); }
}
