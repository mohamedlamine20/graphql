package com.example.graphql.controller;



import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Author> allAuthors() {
        List<Author> authors=authorRepository.findAll();
        return authors;
    }

}
