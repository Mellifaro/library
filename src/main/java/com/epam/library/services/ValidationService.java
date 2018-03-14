package com.epam.library.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    @Value("${author.name.pattern}")
    private static String authorPattern;

    @Value("${book.name.pattern}")
    private static String bookPattern;

    public static boolean validateAuthorName(String name){
        return name.matches(authorPattern);
    }

    public static boolean validateBookTitle(String title){
        return title.matches(bookPattern);
    }
}
