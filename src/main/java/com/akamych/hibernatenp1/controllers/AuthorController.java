package com.akamych.hibernatenp1.controllers;

import com.akamych.hibernatenp1.entities.Author;
import com.akamych.hibernatenp1.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public void getAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        for (Author author : authors) {
            System.out.println("");
            System.out.println("Author: " + author.getName());
            author.getBooks().forEach(book -> System.out.println(" - Book: " + book.getTitle()));
        }
    }
}
