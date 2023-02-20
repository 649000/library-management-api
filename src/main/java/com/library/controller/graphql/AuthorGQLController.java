package com.library.controller.graphql;

import com.library.model.Author;
import com.library.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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

    @QueryMapping(value = "author")
    public Author getAuthor(@Argument String id){
        return authorService.getAuthor(id);
    }
    @MutationMapping(value = "createAuthor")
    public Author createAuthor(@Argument Author input){
        log.debug("Author Object: {}", input.toString());
        return authorService.createAuthor(input);
    }

    @MutationMapping(value = "updateAuthor")
    public Author updateAuthor (@Argument String id, @Argument Author input) {
        log.debug("Author ID: {}", id);
        log.debug("Author Object: {}", input.toString());
        return authorService.updateAuthor(id, input);
    }

    @MutationMapping(value = "deleteAuthor")
    public Author deleteAuthor (@Argument String id) {
        log.debug("Author ID: {}", id);
        authorService.deleteAuthor(id);
        Author author = new Author();
        author.setId(id);
        return author;
    }
}
