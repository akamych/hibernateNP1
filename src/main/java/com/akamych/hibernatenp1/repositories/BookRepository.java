package com.akamych.hibernatenp1.repositories;

import com.akamych.hibernatenp1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
