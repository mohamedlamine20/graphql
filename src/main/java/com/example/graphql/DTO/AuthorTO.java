package com.example.graphql.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorTO {
    private Integer id;
    private String firstName;
    private String lastName;

}
