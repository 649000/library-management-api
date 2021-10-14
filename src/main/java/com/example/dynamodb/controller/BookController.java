package com.example.dynamodb.controller;

import com.example.dynamodb.model.Book;
import com.example.dynamodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity readBooks(@RequestParam(required = false) String isbn) {
        if (isbn == null) {
            return ResponseEntity.ok(bookService.readBooks());
        }

        return ResponseEntity.ok(bookService.readBook(isbn));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> readBook (@PathVariable String bookId) {
        return ResponseEntity.ok(bookService.readBookById(bookId));
    }

    @PostMapping
    public ResponseEntity<Book> createBook (@RequestBody Book request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<Book> updateBook (@PathVariable("bookId") String bookId, @RequestBody Book request) {
        return ResponseEntity.ok(bookService.updateBook(bookId, request));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook (@PathVariable String bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
