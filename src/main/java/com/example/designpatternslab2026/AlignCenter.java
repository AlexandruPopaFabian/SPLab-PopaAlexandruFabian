package com.example.designpatternslab2026;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph: #center " + paragraph.getText() + " #center");
    }
}
