package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.model.Author;
import com.library.model.Mapper;
import com.library.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final Mapper mapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, Mapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
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
        if (optionalAuthor.isEmpty()) {
            throw new EntityNotFoundException("Author Not Found");
        }

        Author newAuthor = mapper.updateAuthor(author, optionalAuthor.get());
        return authorRepository.save(newAuthor);
    }

    public void deleteAuthor(final String authorId) {
        authorRepository.deleteById(authorId);
    }

}
