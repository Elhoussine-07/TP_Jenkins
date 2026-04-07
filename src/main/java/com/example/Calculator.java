package com.example;

public class Calculator {

    //addition
    public int add(int a, int b) {
        return a + b;
    }

    //substraction
    public int subtract(int a, int b) {
        return a - b;
    }

    //multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

   //division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }
}