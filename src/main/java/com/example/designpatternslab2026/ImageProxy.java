package com.example.designpatternslab2026;

public class ImageProxy implements Element {
    private String url;
    private Image realImg = null;

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImg == null) {
            realImg = new Image(url);
        }
        return realImg;
    }

    @Override
    public void print() {
        loadImage().print();
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
