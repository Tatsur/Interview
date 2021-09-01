package com.ttsr.homework1.polymorphism;

public class Triangle extends Shape {
    private final int legA;
    private final int legB;
    private final int legC;

    public Triangle(int legA, int legB, int legC) {
        this.legA = legA;
        this.legB = legB;
        this.legC = legC;
    }

    @Override
    public double getArea() {
        double p = (legA + legB + legC)/2d;
        return Math.sqrt(p*(p-legA)*(p-legB)*(p-legC));
    }

    @Override
    public String getInfo() {
        return String.format("Triangle[%s,%s,%s]:area=%.2f",legA,legB,legC,getArea());
    }
}
