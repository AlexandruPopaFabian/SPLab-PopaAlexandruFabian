package com.example.designpatternslab2026.services;

import com.example.designpatternslab2026.Book;
import com.example.designpatternslab2026.persistence.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final CrudRepository<Book, Long> booksRepository;

    @Autowired
    public BooksService(CrudRepository<Book, Long> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (booksRepository.findById(id).isPresent()) {
            book.setId(id);
            return booksRepository.save(book);
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        if (booksRepository.findById(id).isPresent()) {
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}