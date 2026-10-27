package com.example.designpatternslab2026.commands;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.services.BooksService;
import java.util.List;

public class FindAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;

    public FindAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}
