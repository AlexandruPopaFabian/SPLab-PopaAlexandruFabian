package com.example.designpatternslab2026.services;

import com.example.designpatternslab2026.Book;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}