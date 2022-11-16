package com.example.dynamodb.controller;

import com.example.dynamodb.model.Book;
import com.example.dynamodb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/book")
@Slf4j
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity readBooks() {
        return ResponseEntity.ok(bookService.readBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> readBook (@PathVariable String bookId) {
        log.debug("Book ID: {}", bookId);
        return ResponseEntity.ok(bookService.readBookById(bookId));
    }

    @PostMapping
    public ResponseEntity<Book> createBook (@RequestBody Book request) {
        log.debug("Book Object: {}", request.toString());
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<Book> updateBook (@PathVariable("bookId") String bookId, @RequestBody Book request) {
        log.debug("Book ID: {}", bookId);
        log.debug("Book Object: {}", request.toString());
        return ResponseEntity.ok(bookService.updateBook(bookId, request));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook (@PathVariable String bookId) {
        log.debug("Book ID: {}", bookId);
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
