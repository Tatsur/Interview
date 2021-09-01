package com.ttsr.homework1.polymorphism;

public class Circle extends Shape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String getInfo() {
        return String.format("Circle[%s]:area=%.2f",radius,getArea());
    }
}
