package com.ttsr.homework1.refactoring;

abstract class Car {
    private Engine engine;//нет смысла в публичности
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car is starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
