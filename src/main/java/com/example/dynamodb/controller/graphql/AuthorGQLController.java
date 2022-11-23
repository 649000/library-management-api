package com.example.dynamodb.controller.graphql;

import com.example.dynamodb.model.Author;
import com.example.dynamodb.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class AuthorGQLController {
    private final AuthorService authorService;

    @Autowired
    public AuthorGQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping(value = "authors")
    public Iterable<Author> getAllAuthors(){
        return authorService.getAuthors();
    }
}
