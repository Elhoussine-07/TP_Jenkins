package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculatrice Simple ===");
        System.out.println("1. Addition");
        System.out.println("2. Soustraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choisissez une option (1-4): ");

        int choice = scanner.nextInt();

        System.out.print("Entrez le premier nombre: ");
        int a = scanner.nextInt();
        System.out.print("Entrez le deuxième nombre: ");
        int b = scanner.nextInt();

        int result = 0;
        String operation = "";

        switch (choice) {
            case 1:
                result = calc.add(a, b);
                operation = "Addition";
                break;
            case 2:
                result = calc.subtract(a, b);
                operation = "Soustraction";
                break;
            case 3:
                result = calc.multiply(a, b);
                operation = "Multiplication";
                break;
            case 4:
                try {
                    result = calc.divide(a, b);
                    operation = "Division";
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur: " + e.getMessage());
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Option invalide");
                scanner.close();
                return;
        }

        System.out.println("Résultat de " + operation + ": " + result);
        scanner.close();
    }
}