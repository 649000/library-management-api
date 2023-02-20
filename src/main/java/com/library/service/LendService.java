package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.exception.InactiveUserException;
import com.library.exception.UnavailableBookException;
import com.library.model.*;
import com.library.repository.BookRepository;
import com.library.repository.LendRepository;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class LendService {

    private final LendRepository lendRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LendService(LendRepository lendRepository, MemberRepository memberRepository, BookRepository bookRepository) {
        this.lendRepository = lendRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public Lend createLend(Lend request) {
        Optional<Member> memberForId = memberRepository.findById(request.getMemberId());
        if (memberForId.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }
        Member member = memberForId.get();
        if (member.getStatus() != MemberStatus.ACTIVE) {
            throw new InactiveUserException("User is not active to proceed a lending.");
        }

        Optional<Book> bookForId = bookRepository.findById(request.getBookId());
        if (bookForId.isEmpty()) {
            throw new EntityNotFoundException("Cant find any book under given ID");
        }
        //Checking if the book is borrowed
        Optional<Lend> borrowedBook = lendRepository.findByBookIdAndStatus(bookForId.get().getId(), LendStatus.BORROWED);
        if (borrowedBook.isEmpty()) {
            request.setStatus(LendStatus.BORROWED);
            request.setStartOn(Instant.now().toString());
            request.setDueOn(Instant.now().plus(30, ChronoUnit.DAYS).toString());
            return lendRepository.save(request);
        }
        throw new UnavailableBookException("Book is not available");
    }
    public Iterable<Lend> getLends() {
        return lendRepository.findAll();
    }

    public void deleteLend(String id) {
        lendRepository.deleteById(id);
    }

}
