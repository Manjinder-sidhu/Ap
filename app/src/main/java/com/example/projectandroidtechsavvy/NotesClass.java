package com.example.projectandroidtechsavvy;

public class NotesClass {
    int id;
    String title;
    String text;

    public NotesClass(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
