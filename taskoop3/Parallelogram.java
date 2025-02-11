package org.example.taskoop3;

public abstract class Parallelogram implements Figure {

    double a;
    double h;

    @Override
    public double getArea(){
        return a * h;
    }

    public Parallelogram(double a, double h) {
        this.a = a;
        this.h = h;
    }
}

