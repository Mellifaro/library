package com.epam.library.controllers;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public List<AuthorDTO> getAll(){
        return authorService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public AuthorDTO getById(@PathVariable Long id){
        return authorService.getAuthorDTO(id);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public AuthorDTO addAuthor(@RequestBody AuthorDTO author){
        return authorService.save(author);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO author){
        return authorService.update(author);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
    }

    @RequestMapping(path = "/{id}/book/{book_id}", method = RequestMethod.POST)
    public void addBookToAuthor(@PathVariable Long id, @PathVariable Long book_id ){
        authorService.addBookToAuthor(id, book_id);
    }
}
