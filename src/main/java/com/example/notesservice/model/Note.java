package com.example.notesservice.model;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class Note {

    private UUID uuid;
    private Date date;
    private String author;
    private String text;

    public Note(UUID uuid, Date date, String author, String text) {

        this.uuid = uuid;
        this.date = date;
        this.author = author;
        this.text = text;
    }
}
