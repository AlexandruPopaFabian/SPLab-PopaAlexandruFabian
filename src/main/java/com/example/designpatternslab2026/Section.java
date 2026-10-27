package com.example.designpatternslab2026;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Section extends BaseElement {
    protected String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    protected List<Element> children = new ArrayList<>();

    public Section() {
        // Constructor fără argumente necesar pentru JPA
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getChildren() {
        return children;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element child : children) {
            child.print();
        }
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}