package com.example.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@CrossOrigin(origins = "http://localhost:8080/graphql")
@Controller
public class GraphQlApplication {
  @GetMapping("/")
  public String home(){
      return "dist/comps/index.html";
  }
    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }

}
