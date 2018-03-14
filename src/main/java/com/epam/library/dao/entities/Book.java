package com.epam.library.dao.entities;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Viktor Skapoushchenko on 06.02.2018.
 */
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {""})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
