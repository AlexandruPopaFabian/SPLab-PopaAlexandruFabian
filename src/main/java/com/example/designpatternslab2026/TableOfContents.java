package com.example.designpatternslab2026;

public class TableOfContents implements Element {
    private String something;

    public TableOfContents(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("TableOfContents: " + something);
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
