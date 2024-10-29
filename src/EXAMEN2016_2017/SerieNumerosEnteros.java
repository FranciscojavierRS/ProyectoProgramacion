package EXAMEN2016_2017;

import java.util.Scanner;

/** Escríbase un programa en Java que permita introducir una serie de
números enteros (cada número mediante un diálogo JOptionPane, se van a introducir más de dos, no se
van a repetir), que terminará al introducir uno negativo. Se debe mostrar al final cuántas veces el
último número introducido (cada vez que se introduce uno) es el tercero de los tres mayores de todos
los introducidos hasta ese momento */

public class SerieNumerosEnteros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para almacenar los tres números más grandes
        int mayor1 = Integer.MIN_VALUE; // Primer mayor
        int mayor2 = Integer.MIN_VALUE; // Segundo mayor
        int mayor3 = Integer.MIN_VALUE; // Tercer mayor
        int contadorTercerMayor = 0;    // Contador de veces que el último número es el tercer mayor

        while (true) {
            // Solicitar un número
            System.out.print("Introduce un número entero (número negativo para terminar): ");
            int numero = scanner.nextInt();

            // Si se introduce un número negativo, terminamos el bucle
            if (numero < 0) {
                break;
            }

            // Actualizar los tres mayores
            if (numero > mayor1) {
                mayor3 = mayor2;
                mayor2 = mayor1;
                mayor1 = numero;
            } else if (numero > mayor2) {
                mayor3 = mayor2;
                mayor2 = numero;
            } else if (numero > mayor3) {
                mayor3 = numero;
            }

            // Comprobar si el número actual es el tercer mayor
            if (numero == mayor3) {
                contadorTercerMayor++;
            }
        }

        // Mostrar el resultado final
        System.out.println("El último número introducido fue el tercer mayor en " + contadorTercerMayor + " ocasiones.");

        scanner.close();
    }
}

