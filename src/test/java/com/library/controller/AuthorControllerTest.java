package com.library.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
    public void getAuthors() throws Exception {
        //Allow testing of HTTP status code and JSON response
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/author")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
