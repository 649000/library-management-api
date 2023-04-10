package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;
    @Test
    public void getBookById() throws Exception {
        // Alternative implementation compared to AuthorController
        Book book = new Book();
        book.setId("649000");
        book.setName("12 Rules for Life");
        book.setIsbn("978-0345816023");
        when(service.readBookById("649000")).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/book/649000"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
