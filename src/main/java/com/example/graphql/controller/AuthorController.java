package com.example.graphql.controller;


import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.example.graphql.AuthorDTO;
import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final CriteriaBuilderFactory cbf;
    private final EntityViewManager evm;

    public AuthorController(AuthorRepository authorRepository, EntityManager entityManager, CriteriaBuilderFactory cbf, EntityViewManager evm) {
        this.authorRepository = authorRepository;
        this.entityManager = entityManager;
        this.cbf = cbf;
        this.evm = evm;
    }

    @QueryMapping
    public List<Author> allAuthors() {
        System.out.println("+++++++++++++++++++++++++++++");
        this.getAll().forEach(authorDTO ->
                System.out.println(authorDTO.getBookSet()));
        System.out.println("+++++++++++++++++++++++++++++");
        List<Author> authors = authorRepository.findAll();

        return authors;
    }


    public List<AuthorDTO> getAll() {
        CriteriaBuilder<Author> cb = cbf.create(entityManager, Author.class);
        CriteriaBuilder<AuthorDTO> bookDTOCriteriaBuilder =
                evm.applySetting(EntityViewSetting.create(AuthorDTO.class), cb);
        List<AuthorDTO> authorDTOS = bookDTOCriteriaBuilder.getResultList();
        return authorDTOS;

    }

}
