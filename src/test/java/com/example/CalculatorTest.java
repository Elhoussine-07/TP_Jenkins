package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test de l'addition")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Test de la soustraction")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(0, calculator.subtract(10, 10));
    }

    @Test
    @DisplayName("Test de la multiplication")
    void testMultiply() {
        assertEquals(15, calculator.multiply(3, 5));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-6, calculator.multiply(-2, 3));
    }

    @Test
    @DisplayName("Test de la division")
    void testDivide() {
        assertEquals(4, calculator.divide(20, 5));
        assertEquals(0, calculator.divide(0, 5));
        assertEquals(-2, calculator.divide(-6, 3));
    }

    @Test
    @DisplayName("Test division par zéro")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @DisplayName("Test avec plusieurs assertions")
    void testMultipleOperations() {
        assertAll("Tests multiples",
                () -> assertEquals(8, calculator.add(5, 3)),
                () -> assertEquals(2, calculator.subtract(10, 8)),
                () -> assertEquals(20, calculator.multiply(4, 5)),
                () -> assertEquals(3, calculator.divide(9, 3))
        );
    }
}