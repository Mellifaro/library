package com.epam.library.dao.dto;

import com.epam.library.dao.entities.Book;

public class BookDTO {
    private long id;
    private String title;
    private String author;

    public BookDTO() {
    }

    public BookDTO(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookDTO(Book book) {
        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor().getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
