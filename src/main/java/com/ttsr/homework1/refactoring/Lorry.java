package com.ttsr.homework1.refactoring;

//наследует класс Car, но реализует интерфейсы Movable и Stoppable
//обязан реализовать абстрактный метод класса Car - open()
class Lorry extends Car implements Movable, Stoppable {

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
}
