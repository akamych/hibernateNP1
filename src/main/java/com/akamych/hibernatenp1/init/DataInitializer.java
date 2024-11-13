package com.akamych.hibernatenp1.init;

import com.akamych.hibernatenp1.entities.Author;
import com.akamych.hibernatenp1.entities.Book;
import com.akamych.hibernatenp1.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final Random random = new Random();

    public DataInitializer(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Author> authors = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Author author = new Author();
            author.setName("Author " + i);
            authors.add(author);
        }

        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Book book = new Book();
            book.setTitle("Book " + i);

            Author author = authors.get(random.nextInt(authors.size()));
            book.setAuthor(author);

            if (author.getBooks() == null) {
                author.setBooks(new ArrayList<>());
            }
            author.getBooks().add(book);

            books.add(book);
        }

        authorRepository.saveAll(authors);
    }

}
