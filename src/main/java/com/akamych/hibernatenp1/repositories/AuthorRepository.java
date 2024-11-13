package com.akamych.hibernatenp1.repositories;

import com.akamych.hibernatenp1.entities.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @EntityGraph(attributePaths = "books")
    @Query("SELECT a FROM Author a")
    List<Author> findAllWithBooks();

    @Query("SELECT a FROM Author a JOIN FETCH a.books")
    List<Author> findAllAuthorsWithBooks();
}
