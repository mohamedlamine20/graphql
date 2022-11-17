package com.example.graphql;



import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.model.Rating;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Book> books = new ArrayList<>();
        books.add(new Book( "Reactive Spring", 484, Rating.FIVE_STARS, null));
        books.add(new Book( "Spring Boot Up & Running", 328, Rating.FIVE_STARS, null));
        books.add(new Book( "Hacking with Spring Boot 2.3", 392, Rating.FIVE_STARS, null));
        List<Author> authors = new ArrayList<>();
        authors.add(new Author( "Josh", "Long", null));
        authors.add(new Author("Mark", "Heckler",null));
        authors.add(new Author ("Greg", "Turnquist",  null));
        bookRepository.saveAll(books);
        authorRepository.saveAll(authors);

    }
}
