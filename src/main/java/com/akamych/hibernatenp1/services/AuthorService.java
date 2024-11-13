package com.akamych.hibernatenp1.services;


import com.akamych.hibernatenp1.entities.Author;
import com.akamych.hibernatenp1.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {

//        entitygraph solution
//        return authorRepository.findAllWithBooks();

//        join fetch solution
//        return authorRepository.findAllAuthorsWithBooks();

        return authorRepository.findAll();
    }
}
