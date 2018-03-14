package com.epam.library.services;

import com.epam.library.dao.dto.BookDTO;
import com.epam.library.dao.entities.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
public interface BookService {
    BookDTO get(Long id);

    List<BookDTO> getAll();

    Book save(Book author);

    void delete(Long id);

    Book update(Book author);

    List<BookDTO> getByAuthor(Long authorId);
}
