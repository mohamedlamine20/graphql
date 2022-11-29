package com.example.graphql.controller;


import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {

    private final BookRepository bookRepository;

    private  final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @MutationMapping
    public Book addBook(@Argument String title ,@Argument  Integer pages){
        return bookRepository.save(Book.builder().title(title).pages(pages).build());
    }

    @MutationMapping
    public Book addAuthorToBook(@Argument Integer bookId ,@Argument  Integer authorId){
        Book book =bookRepository.findById(bookId).orElseThrow();
        Author author=authorRepository.findById(authorId).orElseThrow();
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public String deleteBook(@Argument Integer bookId){
        bookRepository.deleteById(bookId);
        return "deleted";
    }
}
