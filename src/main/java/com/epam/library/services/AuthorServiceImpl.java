package com.epam.library.services;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;
import com.epam.library.dao.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viktor Skapoushchenko on 07.02.2018.
 */
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private ValidationService validationService;

    public Author get(Long id){
        return authorRepository.findOne(id);
    }

    @Override
    public AuthorDTO getAuthorDTO(Long id) {
        return new AuthorDTO(get(id));
    }

    @Override
    public Author getByName(String author) {
        return authorRepository.findByName(author);
    }

    @Override
    public List<AuthorDTO> getAll() {
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
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        Author author = new Author();
        authorRepository.save(updateFromDto(authorDTO, author));
        return authorDTO;
    }

    @Override
    public AuthorDTO update(AuthorDTO author) {
        Author found = get(author.getId());
        authorRepository.save(updateFromDto(author, found));
        return new AuthorDTO(found);
    }

    @Override
    public void delete(Long id) {
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
