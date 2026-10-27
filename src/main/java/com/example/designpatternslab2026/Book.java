package com.example.designpatternslab2026;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Section {

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public Book() {}

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() { return authors; }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}