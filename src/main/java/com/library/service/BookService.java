package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Mapper;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final Mapper mapper;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, Mapper mapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public Book readBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new EntityNotFoundException("Cant find any book under given ID");
    }
    public Iterable<Book> readBooks() {
        return bookRepository.findAll();
    }
    public Book readBook(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        if (book.isPresent()) {
            return book.get();
        }
        throw new EntityNotFoundException("Cant find any book under given ISBN");
    }

    public Book createBook(Book book) {
        Optional<Author> author = authorRepository.findById(book.getAuthorId());
        if (author.isEmpty()) {
            throw new EntityNotFoundException("Author Not Found");
        }
        return bookRepository.save(book);
    }
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(String bookId, Book request) {
        Optional<Author> author = authorRepository.findById(request.getAuthorId());
        if (author.isEmpty()) {
            throw new EntityNotFoundException("Author Not Found");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new EntityNotFoundException("Book Not Found");
        }

        Book book = mapper.updateBook(request, optionalBook.get());
        log.debug(book.toString());
        return bookRepository.save(book);
    }
}
