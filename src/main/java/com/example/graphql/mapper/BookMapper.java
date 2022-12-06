package com.example.graphql.mapper;


import com.example.graphql.BookTo;
import com.example.graphql.model.Book;
import org.mapstruct.Mapper;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface BookMapper  extends Serializable {


    Book form(BookTo bookTo);


    BookTo to(Book book);




}
