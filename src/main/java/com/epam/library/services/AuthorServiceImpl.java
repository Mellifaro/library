package com.epam.library.services;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;
import com.epam.library.dao.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
@Service
public class AuthorServiceImpl implements AuthorService{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private ValidationService validationService;

    public Author get(Long id){
        log.info("Getting author with id" + id);
        return authorRepository.findOne(id);
    }

    @Override
    public AuthorDTO getAuthorDTO(Long id) {
        return new AuthorDTO(get(id));
    }

    @Override
    public Author getByName(String author) {
        log.info("Getting author ny name: " + author);
        return authorRepository.findByName(author);
    }

    @Override
    public List<AuthorDTO> getAll() {
        log.info("Receiving all users");
        return authorRepository.findAll()
                .stream()
                .map(AuthorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void addBookToAuthor(Long authorId, Long bookId) {
        Author author = get(authorId);
        Book book = bookService.get(bookId);
        author.getBooks().add(book);
        authorRepository.save(author);
        log.info("Added book with id:" + bookId + " to author with id:" + authorId);
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        Author author = new Author();
        authorRepository.save(updateFromDto(authorDTO, author));
        log.info("Saved author: " + authorDTO.getName());
        return authorDTO;
    }

    @Override
    public AuthorDTO update(AuthorDTO author) {
        Author found = get(author.getId());
        authorRepository.save(updateFromDto(author, found));
        log.info("Updated author: " + author.getName());
        return new AuthorDTO(found);
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting author with id: " + id);
        authorRepository.delete(id);
    }

    private Author updateFromDto(AuthorDTO authorDTO, Author found) {
        if(!validationService.isValidAuthorName(authorDTO.getName())){
            throw new IllegalStateException("Author name \"" + authorDTO.getName() + "\" is not valid");
        }
        found.setName(authorDTO.getName());
        return found;
    }
}
