package com.epam.library.services;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;
import com.epam.library.dao.repositories.AuthorRepository;
import com.epam.library.dao.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
@Service
@Profile({"local", "prod", "default"})
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public AuthorDTO get(Long id) {
        return new AuthorDTO(authorRepository.findOne(id));
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Book addBookToAuthor(Long authorId, Long bookId) {
        Author author = getWithBooks(authorId);
        Book book = bookRepository.findOne(bookId);
        author.getBooks().add(book);
        authorRepository.save(author);
        return book;
    }

    @Override
    public Author getWithBooks(Long id) {
        return authorRepository.findWithBooks(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }
}
