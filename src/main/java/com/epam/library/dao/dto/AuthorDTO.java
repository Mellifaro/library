package com.epam.library.dao.dto;

import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {
    private Long id;

    @NotNull
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
