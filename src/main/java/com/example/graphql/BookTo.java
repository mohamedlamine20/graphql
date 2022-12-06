package com.example.graphql;

import com.example.graphql.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookTo {

    Integer id;
    String title;
    Integer pages;
    Rating rating;


}
