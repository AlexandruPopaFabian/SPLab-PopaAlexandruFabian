package com.example.designpatternslab2026.services;

import com.example.designpatternslab2026.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BooksService {
    private final Map<Long, Book> books = new HashMap<>();
    private long idCounter = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        // Simulăm atribuirea unui ID
        books.put(idCounter, book);
        idCounter++;
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (books.containsKey(id)) {
            books.put(id, book);
            return book;
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}