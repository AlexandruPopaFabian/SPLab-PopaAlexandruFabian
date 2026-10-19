package com.example.designpatternslab2026;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsLab2026Application {

    public static void main(String[] args) throws Exception {
        // 1. Creăm cartea și capitolele/secțiunile
        Book book = new Book("Design Patterns Book");

        Section cap1 = new Section("Capitolul 1: Intro");
        cap1.add(new Paragraph("Paragraf 1.1")); // Ocupă Pagina 1
        cap1.add(new ImageProxy("Diagrama 1"));  // Ocupă Pagina 2
        cap1.add(new Paragraph("Paragraf 1.2")); // Ocupă Pagina 3

        Section cap2 = new Section("Capitolul 2: Visitor Pattern");
        cap2.add(new Paragraph("Paragraf 2.1")); // Ocupă Pagina 4
        cap2.add(new ImageProxy("Diagrama 2"));  // Ocupă Pagina 5

        Section cap3 = new Section("Capitolul 3: Concluzii");
        cap3.add(new Paragraph("Paragraf 3.1")); // Ocupă Pagina 6

        // Adăugăm capitolele în carte
        book.addContent(cap1);
        book.addContent(cap2);
        book.addContent(cap3);

        // 2. Creăm vizitatorul pentru generarea cuprinsului și parcurgem cartea
        GenerateToC generateToC = new GenerateToC();
        book.accept(generateToC);

        // 3. Extragere și afișare TableOfContents
        TableOfContents toc = generateToC.getToC();
        toc.print();
    }
}