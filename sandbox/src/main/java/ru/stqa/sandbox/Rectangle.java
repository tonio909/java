package ru.stqa.sandbox;

public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double rectangleArea() {
        return this.a * this.b;
    }
}
