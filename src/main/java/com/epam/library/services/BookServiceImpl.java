package com.epam.library.services;

import com.epam.library.dao.dto.BookDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.dao.entities.Book;
import com.epam.library.dao.repositories.BookRepository;
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
public class BookServiceImpl implements BookService{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ValidationService validationService;

    @Override
    public Book get(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public BookDTO getBookDto(Long id) {
        return new BookDTO(get(id));
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                                        .map(BookDTO::new)
                                        .collect(Collectors.toList());
    }

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = new Book();
        bookRepository.save(updateFromDto(bookDTO, book));
        return bookDTO;
    }


    @Override
    public BookDTO update(BookDTO bookDTO) {
        Book book = get(bookDTO.getId());
        bookRepository.save(updateFromDto(bookDTO, book));
        return bookDTO;
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    private Book updateFromDto(BookDTO bookDTO, Book book){
        Author author = authorService.getByName(bookDTO.getAuthor());
        if(!validationService.isValidBookTitle(bookDTO.getTitle())){
            throw new IllegalStateException("Book title \"" + bookDTO.getTitle() + "\" is not valid");
        }
        if(author == null){
            throw new IllegalStateException("Author can not be null");
        }
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(author);
        return book;
    }
}
