package com.ttsr.homework1.polymorphism;

import java.util.Arrays;
import java.util.List;

public class ShapesTest {
    public static void main(String[] args) {
        Shape one = new Circle(5);
        Shape two = new Triangle(2,2,2);
        Shape three = new Square(5);
        List<Shape> shapes = Arrays.asList(one,two,three);
        for (Shape shape : shapes) {
            System.out.println(shape.getInfo());
        }
    }
}
