package com.example.notesservice.constants;

public class SQLQueries {

    public final static String SELECT_NOTE_BY_UUID = "SELECT uuid, date, author, text FROM notes.notes WHERE uuid = '%s'";
    public final static String IS_EXIST_NOTE = "SELECT exists (SELECT TRUE FROM notes.notes WHERE uuid = '%s') AS is_exist";
    public final static String INSERT_NOTE = "INSERT INTO notes.notes (uuid, date, author, text) VALUES ('%s', '%s', '%s', '%s') RETURNING uuid, date, author, text";
    public final static String DELETE_NOTE_BY_UUID = "DELETE FROM notes.notes WHERE uuid = %s";
}
