package com.example.graphql;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;

import java.util.Set;

@EntityView(
        Author.class
)
public interface AuthorDTO {
    @IdMapping
    Integer getId();


    String getFirstName();

    String getLastName();

    Set<BookDTO> getBookSet();

    @EntityView(Book.class)
    interface BookDTO {
        @IdMapping
        Integer getId();

        String getTitle();

        Integer getPages();
    }

}
