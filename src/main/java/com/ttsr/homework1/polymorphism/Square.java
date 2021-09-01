package com.ttsr.homework1.polymorphism;

public class Square extends Shape {
    private final int size;

    public Square(int size) {
        this.size = size;
    }

    @Override
    public double getArea() {
        return size*size;
    }

    @Override
    public String getInfo() {
        return String.format("Square[%s]:area=%s",size,getArea());
    }
}
