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
    @Setter @Getter private long id;

    @Column(name = "name")
    @Setter @Getter private String name;

    @OneToMany(mappedBy = "author")
    @Setter @Getter private Set<Book> books;
}
