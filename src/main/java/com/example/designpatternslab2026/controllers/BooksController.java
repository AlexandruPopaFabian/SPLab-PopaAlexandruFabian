package com.example.designpatternslab2026.controllers;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.commands.*;
import com.example.designpatternslab2026.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final SynchronousCommandExecutor syncExecutor;
    private final AsynchronousCommandExecutor asyncExecutor;

    @Autowired
    public BooksController(BooksService booksService,
                           SynchronousCommandExecutor syncExecutor,
                           AsynchronousCommandExecutor asyncExecutor) {
        this.booksService = booksService;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
    }

    // 1. GET /books (Sincron)
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> command = new FindAllBooksCommand(booksService);
        return ResponseEntity.ok(syncExecutor.execute(command));
    }

    // 2. GET /books/{id} (Sincron)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Command<Book> command = new FindBookByIdCommand(booksService, id);
        Book book = syncExecutor.execute(command);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    // 3. POST /books (Asincron - 202 Accepted)
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        Command<Book> command = new CreateBookCommand(booksService, book);
        asyncExecutor.execute(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Request accepted and is being processed asynchronously.");
    }

    // 4. PUT /books/{id} (Asincron - 202 Accepted)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Command<Book> command = new UpdateBookCommand(booksService, id, book);
        asyncExecutor.execute(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Update request accepted and is being processed asynchronously.");
    }

    // 5. DELETE /books/{id} (Sincron sau Asincron, ex: Sincron)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Command<Boolean> command = new DeleteBookCommand(booksService, id);
        boolean deleted = syncExecutor.execute(command);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}