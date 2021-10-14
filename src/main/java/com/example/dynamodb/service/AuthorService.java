package com.example.dynamodb.service;

import com.example.dynamodb.exception.EntityNotFoundException;
import com.example.dynamodb.model.Author;
import com.example.dynamodb.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor (Author author) {
        return authorRepository.save(author);
    }

    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(final String authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }

        throw new EntityNotFoundException("Author Not Found");
    }

    public Author updateAuthor(final String authorId, final Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (!optionalAuthor.isPresent()) {
            throw new EntityNotFoundException("Author Not Found");
        }

        Author retrievedAuthor = optionalAuthor.get();
        retrievedAuthor.setFirstName(author.getFirstName());
        retrievedAuthor.setLastName(author.getLastName());

        return authorRepository.save(retrievedAuthor);
    }

    public void deleteAuthor(final String authorId) {
        authorRepository.deleteById(authorId);
    }

}
