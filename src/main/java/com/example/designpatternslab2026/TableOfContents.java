package com.example.designpatternslab2026;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {
    private String something;
    private List<String> entries = new ArrayList<>();

    public TableOfContents(String something) {
        this.something = something;
    }

    public TableOfContents() {}

    public void addEntry(String entry) {
        entries.add(entry);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTableOfContents(this);
    }

    @Override
    public void print() {
        if (something != null) {
            System.out.println("TableOfContents: " + something);
        } else {
            System.out.println("----- Table of Contents -----");
        }

        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Operation not supported on Leaf node");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Operation not supported on Leaf node");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Operation not supported on Leaf node");
    }
}