package com.example.designpatternslab2026;

public class GenerateToC implements Visitor {
    private TableOfContents toc = new TableOfContents();
    private int currentPage = 1;

    @Override
    public void visitBook(Book book) {
        // Book este containerul principal, opțional poți adăuga titlul cărții
    }

    @Override
    public void visitSection(Section section) {
        // Adăugăm capitolul/secțiunea în cuprins cu pagina curentă
        String entry = section.getTitle() + " .................... Page " + currentPage;
        toc.addEntry(entry);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        // Fiecare paragraf ocupă 1 pagină
        currentPage++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        // Fiecare imagine ocupă 1 pagină
        currentPage++;
    }

    @Override
    public void visitImage(Image image) {
        // Fiecare imagine ocupă 1 pagină
        currentPage++;
    }

    @Override
    public void visitTable(Table table) {
        // Dacă tabelele nu ocupă pagini, le ignorăm
    }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {
        // Ignorăm
    }

    public TableOfContents getToC() {
        return toc;
    }
}
