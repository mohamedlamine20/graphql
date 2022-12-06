package com.example.graphql.controller;


import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.example.graphql.BookDTO;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import java.util.List;


@Controller
public class BookController {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final CriteriaBuilderFactory cbf;
    private final EntityViewManager evm;


    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, EntityManager entityManager, CriteriaBuilderFactory cbf, EntityViewManager evm) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.entityManager = entityManager;
        this.cbf = cbf;
        this.evm = evm;
    }

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAll() {
        System.out.println("+++++++++++++++++++++++++++++");
        this.getAll().forEach(bookDTO ->
                System.out.println(bookDTO.getAuthor()));
        System.out.println("+++++++++++++++++++++++++++++");
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
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException());
        Author author = authorRepository.findById(authorId).orElseThrow();
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public String deleteBook(@Argument Integer bookId) {
        bookRepository.deleteById(bookId);
        return "deleted";
    }

    public List<BookDTO> getAll() {
        CriteriaBuilder<Book> cb = cbf.create(entityManager, Book.class);
        CriteriaBuilder<BookDTO> bookDTOCriteriaBuilder =
                evm.applySetting(EntityViewSetting.create(BookDTO.class), cb);
        List<BookDTO> bookDTOS = bookDTOCriteriaBuilder.getResultList();
        return bookDTOS;

    }
}
