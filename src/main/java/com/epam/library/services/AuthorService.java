package com.epam.library.services;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;

import java.util.List;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
public interface AuthorService {

    Author get(Long id);

    AuthorDTO getAuthorDTO(Long id);

    List<AuthorDTO> getAll();

    void addBookToAuthor(Long authorId, Long bookId);

    AuthorDTO save(AuthorDTO author);

    void delete(Long id);

    AuthorDTO update(AuthorDTO author);

    Author getByName(String author);
}
