package com.epam.library.services;

import com.epam.library.dao.dto.BookDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;
import com.epam.library.dao.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public BookDTO get(Long id) {
        return new BookDTO(bookRepository.findOne(id));
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                                        .map(BookDTO::new)
                                        .collect(Collectors.toList());
    }

    @Override
    public Book save(Book author) {
        return bookRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Book update(Book author) {
        return bookRepository.save(author);
    }

    @Override
    public List<BookDTO> getByAuthor(Long authorId) {
        Author author = authorService.getWithBooks(authorId);
        return author.getBooks().stream()
                                .map(BookDTO::new)
                                .collect(Collectors.toList());

    }
}
