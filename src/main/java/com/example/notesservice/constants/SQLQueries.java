package com.example.notesservice.constants;

public class SQLQueries {

    public final static String SELECT_NOTE_BY_UUID = "SELECT uuid, note_date, author, text FROM notes.notes WHERE uuid = %s";
    public final static String IS_EXIST_NOTE = "SELECT TRUE FROM notes.notes WHERE uuid = %s AS is_exist";
}
