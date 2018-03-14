package com.epam.library.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    @Value("${author.name.pattern}")
    private String authorPattern;

    @Value("${book.name.pattern}")
    private String bookPattern;

    public boolean isValidAuthorName(String name){
        return name.matches(authorPattern);
    }

    public boolean isValidBookTitle(String title){
        return title.matches(bookPattern);
    }
}
