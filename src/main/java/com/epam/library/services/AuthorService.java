package com.epam.library.services;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;

import java.util.List;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
public interface AuthorService {

    AuthorDTO get(Long id);

    List<AuthorDTO> getAll();

    Book addBookToAuthor(Long authorId, Long bookId);

    Author getWithBooks(Long id);

    Author save(Author author);

    void delete(Long id);

    Author update(Author author);
}
