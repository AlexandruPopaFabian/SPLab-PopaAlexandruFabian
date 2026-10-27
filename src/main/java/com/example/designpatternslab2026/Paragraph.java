package com.example.designpatternslab2026;

import jakarta.persistence.*;

@Entity
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Override
    public void print() {
        if (textAlignment != null) {
            textAlignment.render(this); // Apelează strategia dacă este setată
        } else {
            System.out.println("Paragraph: " + text); // Formatul implicit fără aliniere
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
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
