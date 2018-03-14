package com.epam.library.controllers;

import com.epam.library.dao.dto.BookDTO;
import com.epam.library.dao.entities.Book;
import com.epam.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<BookDTO> getAll(){
        return bookService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public BookDTO getById(@PathVariable Long id){
        return bookService.get(id);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        return bookService.update(book);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @RequestMapping(path = "/byAuthor/{authorId}", method = RequestMethod.GET)
    public List<BookDTO> getByAuthor(@PathVariable Long authorId){
        return bookService.getByAuthor(authorId);
    }
}
