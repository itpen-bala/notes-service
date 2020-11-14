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


    private String checkIsExistNote = SQLQueries.IS_EXIST_NOTE;
    private String ADD_NOTE = "";
    private String UPDATE_NOTE = "";
    private String DELETE_NOTE = "";

    @Transactional
    public Note addNote(Note note) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uuid", note.getUuid();
        parameter.put("date", note.getDate();
        parameter.put("author", note.getAuthor());
        parameter.put("Text", note.getText());

        final List<Note> result = namedParameterJdbcTemplate.query(ADD_NOTE, parameter, rowMapper()));

        return  result.get(0);
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

    private RowMapper<Boolean> isExistMapper() { return (rs, rowNUm) -> rs.getBoolean("is_exist");

}
