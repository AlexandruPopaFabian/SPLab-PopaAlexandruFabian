package com.example.designpatternslab2026.commands;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.services.BooksService;

public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Long id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Long id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.updateBook(id, book);
    }
}
