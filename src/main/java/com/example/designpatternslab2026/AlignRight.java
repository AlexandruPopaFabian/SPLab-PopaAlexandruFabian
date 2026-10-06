package com.example.designpatternslab2026;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph: #right " + paragraph.getText());
    }
}
