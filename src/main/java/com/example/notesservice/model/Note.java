package com.example.notesservice.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Note {

    private UUID uuid;
    private String date;
    private String author;
    private String text;

}
