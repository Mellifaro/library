package com.epam.library.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Viktor Skapoushchenko on 06.02.2018.
 */
@Entity
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name", "books"})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
