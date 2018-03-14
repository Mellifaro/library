package com.epam.library.dao.dto;

import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {
    private long id;
    private String name;
    private List<String> bookTitles;

    public AuthorDTO() {
    }

    public AuthorDTO(long id, String name, List<String> bookTitles) {
        this.id = id;
        this.name = name;
        this.bookTitles = bookTitles;
    }

    public AuthorDTO(Author author) {
        id = author.getId();
        this.name = author.getName();
        this.bookTitles = author.getBooks().stream()
                                            .map(Book::getTitle)
                                            .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBookTitles() {
        return bookTitles;
    }

    public void setBookTitles(List<String> bookTitles) {
        this.bookTitles = bookTitles;
    }
}
