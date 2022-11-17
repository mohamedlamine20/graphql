package com.example.graphql.model;



import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    public Book(String title, Integer pages, Rating rating, Author author) {
        this.title = title;
        this.pages = pages;
        this.rating = rating;
        this.author = author;
    }

    String title;
    Integer pages;
    Rating rating;
    @ManyToOne()
    Author author;

}
