package com.example;

/**
 * Calculatrice simple pour démonstration
 */
public class Calculator {

    /**
     * Additionne deux nombres
     */


    ///
    /// /
    ///


    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Soustrait deux nombres
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplie deux nombres
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divise deux nombres
     * @throws IllegalArgumentException si b = 0
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }
}