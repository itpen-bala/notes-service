package com.example.notesservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

// TODO: разобраться, нужны ли аннотации
@Data
@Accessors(chain = true)
public class NoteDto {

    private UUID uuid;
    private Date date;
    private String author;
    private String text;
}
