package com.epam.library.services;

import com.epam.library.dao.dto.BookDTO;
import com.epam.library.dao.entities.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
public interface BookService {
    Book get(Long id);

    BookDTO getBookDto(Long id);

    List<BookDTO> getAll();

    BookDTO save(BookDTO bookDTO);

    void delete(Long id);

    BookDTO update(BookDTO bookDTO);
}
