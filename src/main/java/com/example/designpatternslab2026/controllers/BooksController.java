package com.example.designpatternslab2026.controllers;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.persistence.BooksRepository;
import com.example.designpatternslab2026.services.AllBooksSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AllBooksSubject allBooksSubject;

    @PostMapping
    public String newBook(@RequestBody NewBookRequest newBookRequest) {
        Book book = new Book(newBookRequest.getTitle());
        book = booksRepository.save(book); // Salvează în H2
        allBooksSubject.add(book);          // Notifică toți observatorii SSE
        return "Book saved [" + book.getId() + "] " + book.getTitle();
    }
}