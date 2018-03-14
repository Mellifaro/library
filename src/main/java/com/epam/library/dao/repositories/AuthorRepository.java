package com.epam.library.dao.repositories;

import com.epam.library.dao.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id=:id")
    Author findWithBooks(@Param("id") Long id);
}
