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
    @Setter @Getter private long id;

    @Column(name = "title")
    @Setter @Getter private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Setter @Getter private Author author;
}
