package com.example.designpatternslab2026;

public interface Element {
    void print();
    void accept(Visitor visitor);
    void add(Element element);
    void remove(Element element);
    Element get(int index);
}
