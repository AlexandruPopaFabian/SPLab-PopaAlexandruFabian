package com.example.designpatternslab2026;

public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
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
