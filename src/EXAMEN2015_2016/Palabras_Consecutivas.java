package EXAMEN2015_2016;

import java.util.Scanner;

public class Palabras_Consecutivas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para almacenar las tres últimas palabras consecutivas
        String palabra1 = "";
        String palabra2 = "";
        String palabra3 = "";
        int contadorCondicion = 0;
        int palabraIngresada = 0; // Contador de palabras válidas (no "fin")

        while (true) {
            // Solicitar la palabra usando System.out.print y leer con Scanner
            System.out.print("Introduce una palabra (o 'fin' para terminar): ");
            String palabra = scanner.nextLine();

            // Terminar el bucle si la palabra es "fin"
            if (palabra.equalsIgnoreCase("fin")) {
                break;
            }

            // Incrementar el contador de palabras ingresadas
            palabraIngresada++;

            // Desplazar las palabras
            palabra1 = palabra2;
            palabra2 = palabra3;
            palabra3 = palabra;

            // Se empieza a verificar la condición solo cuando se han ingresado al menos tres palabras
            if (palabraIngresada >= 3) {
                // Verificar si palabra1 es más corta que palabra2 y palabra3
                if (palabra1.length() < palabra2.length() && palabra1.length() < palabra3.length()) {
                    contadorCondicion++;
                }
            }
        }

        // Mostrar el resultado final
        System.out.println("Se ha introducido una palabra más corta que las dos siguientes " + contadorCondicion + " veces.");

        scanner.close();
    }
}
