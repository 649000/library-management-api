package com.library.service;

import com.library.model.Author;
import com.library.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
public class AuthorServiceTest {

    @InjectMocks
    private AuthorService authorService;
    @Mock
    private AuthorRepository authorRepository;
    @BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAuthor() {
        when(authorRepository.save(getAuthor())).thenReturn(getAuthor());
        Author outcome = authorService.createAuthor(getAuthor());
        assertEquals(outcome.getId(), getAuthor().getId());
    }

    private Author getAuthor(){
        Author author = new Author();
        author.setId("1");
        author.setFirstName("Jordan");
        author.setLastName("Peterson");
        return author;
    }
}
