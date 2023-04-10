package com.library.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BookTest {

    @Test
    public void getId_IDEquals_True() {
        Book book = new Book();
        book.setId("bookId");
        assertEquals("bookId", book.getId());
    }
}
