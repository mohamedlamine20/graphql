package com.example.graphql.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorTO {


    @NotBlank
    private Integer id;
    private String firstName;
    private String lastName;

}
