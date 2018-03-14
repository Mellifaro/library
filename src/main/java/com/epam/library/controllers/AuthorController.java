package com.epam.library.controllers;

import com.epam.library.dao.dto.AuthorDTO;
import com.epam.library.dao.entities.Author;
import com.epam.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<AuthorDTO> getAll(){
        return authorService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public AuthorDTO getById(@PathVariable Long id){
        return authorService.get(id);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        return authorService.save(author);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Author updateAuthor(@RequestBody Author author){
        return authorService.update(author);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id){
        authorService.delete(id);
    }

    @RequestMapping(path = "/{id}/book/{book_id}", method = RequestMethod.POST)
    public void addProfToPerson(@PathVariable Long id, @PathVariable Long book_id ){
        authorService.addBookToAuthor(id, book_id);
    }

}
