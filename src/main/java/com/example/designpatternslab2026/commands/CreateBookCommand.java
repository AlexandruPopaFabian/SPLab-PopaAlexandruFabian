package com.example.designpatternslab2026.commands;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.services.BooksService;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.createBook(book);
    }
}
