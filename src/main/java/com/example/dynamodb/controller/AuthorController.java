package com.example.dynamodb.controller;

import com.example.dynamodb.model.Author;
import com.example.dynamodb.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/author")
@Slf4j
public class AuthorController {
    /**
     * Method return can be the Java objects or ResponseEntity
     * ResponseEntity is ideal for setting customized body, header and status code
     */

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor (@RequestBody Author request) {
        log.debug("Author Object: {}", request.toString());
        return authorService.createAuthor(request);
    }

    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable String authorId) {
        log.debug("Author ID: {}", authorId);
        return authorService.getAuthor(authorId);
    }

    @GetMapping
    public Iterable<Author> getAllAuthors(){
        return authorService.getAuthors();
    }

    @PatchMapping("/{authorId}")
    public Author updateAuthor (@PathVariable("authorId") String authorId, @RequestBody Author request) {
        log.debug("Author ID: {}", authorId);
        log.debug("Author Object: {}", request.toString());
        return authorService.updateAuthor(authorId, request);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor (@PathVariable String authorId) {
        log.debug("Author ID: {}", authorId);
        authorService.deleteAuthor(authorId);
    }


}
