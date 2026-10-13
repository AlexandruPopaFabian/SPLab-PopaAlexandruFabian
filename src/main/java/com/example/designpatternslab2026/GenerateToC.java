package com.example.designpatternslab2026;

public class GenerateToC implements Visitor {
    private TableOfContents toc = new TableOfContents();

    @Override
    public void visitBook(Book book) { }

    @Override
    public void visitSection(Section section) { }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) { }

    @Override
    public void visitParagraph(Paragraph paragraph) { }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) { }

    @Override
    public void visitImage(Image image) { }

    @Override
    public void visitTable(Table table) { }

    public TableOfContents getToC() {
        return toc;
    }
}
