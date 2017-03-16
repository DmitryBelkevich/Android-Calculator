package com.hard.calculator;

import android.widget.Toast;

public class Arithmetics {
    public double sum(double a, double b) {
        return a + b;
    }

    public double dif(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0)
            throw new ArithmeticException();

        return a / b;
    }
}