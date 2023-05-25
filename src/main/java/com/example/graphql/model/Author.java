package com.example.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String firstName;
    String lastName;

    public Author(String firstName, String lastName, List<Book> bookSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookSet = bookSet;
    }

    @OneToMany(mappedBy = "author",fetch =FetchType.EAGER)
    List<Book> bookSet=new ArrayList<>();


}

