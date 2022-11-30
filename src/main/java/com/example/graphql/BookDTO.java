package com.example.graphql;


import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;

import java.io.Serializable;

@EntityView(Book.class)
public interface BookDTO {

    @IdMapping
    Integer getId();

    String getTitle();

    Integer getPages();

    AuthorDTO getAuthor();

    @EntityView(Author.class)
    interface AuthorDTO extends Serializable {
        @IdMapping
        Integer getId();


        String getFirstName();

        String getLastName();
    }
}
