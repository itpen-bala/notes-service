package com.example.notesservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

// TODO: разобраться, нужны ли аннотации
@Data
@Accessors(chain = true)
public class NoteDto {

    private UUID uuid;
    private String date;
    private String author;
    private String text;
}
