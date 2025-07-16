package com.github.eorlsam.texteditorapp.model;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String content;
    private Integer charCount;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.charCount = content.length();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getCharCount() {
        return charCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
        this.charCount = content.length();
    }

    @Override
    public String toString() {
        return title; // for ListView display or debugging
    }
}
