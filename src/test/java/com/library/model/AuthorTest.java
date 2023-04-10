package com.library.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class AuthorTest {
    @BeforeAll
    static void setup() {
        log.info("Startup - creating DB connection");
    }
    @BeforeEach
    public void beforeEach() {
       log.info("Before Each Class");
    }

    @AfterEach
    public void afterEach() {
        log.info("After Each Class");
    }

    @AfterAll
    static void tearDown() {
        log.info("Closing DB Connection");
    }
    @Test
    @Tag("Author")
    public void getId_IDEquals_True() {
        Author author = new Author();
        author.setId("authorID");
        assertEquals("authorID", author.getId());
    }

    @Test
    public void getId_IDNotNull_True() {
        Author author = new Author();
        author.setId("authorID");
        assertNotNull("authorID", author.getId());
    }
    @Test
    @Disabled
    public void getId_IDNotNull_False() {
        Author author = new Author();
        author.setId("authorID");
        assertNotEquals("authorID123", author.getId());
    }
}
