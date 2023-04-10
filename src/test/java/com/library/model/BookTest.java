package com.library.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BookTest {
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
    public void getId_IDEquals_True() {
        Book book = new Book();
        book.setId("bookId");
        assertEquals("bookId", book.getId());
    }
}
