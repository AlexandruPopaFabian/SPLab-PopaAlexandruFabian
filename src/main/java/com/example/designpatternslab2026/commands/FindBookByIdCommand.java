package com.example.designpatternslab2026.commands;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.services.BooksService;

public class FindBookByIdCommand implements Command<Book> {
    private final BooksService booksService;
    private final Long id;

    public FindBookByIdCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.getBookById(id);
    }
}
