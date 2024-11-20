package EjerciciosTABLAS;

import java.util.Scanner;
import java.util.Random;

public class Ej4_LaCamaraSecreta {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Solicitar al jugador que introduzca la longitud de la clave secreta
        System.out.print("Introduzca la longitud de la clave secreta: ");
        int longitud = scanner.nextInt();

        // Generar la clave secreta de forma aleatoria con dígitos del 1 al 5
        int[] claveSecreta = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            claveSecreta[i] = random.nextInt(5) + 1; // genera un número entre 1 y 5
        }

        // Variable para controlar si el jugador ha acertado la clave
        boolean acertado = false;

        // Bucle para que el jugador siga intentando hasta acertar la clave
        while (!acertado) {
            // Solicitar al jugador que introduzca una combinación de prueba
            System.out.println("Intente acertar la combinación secreta:");
            int[] intento = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                intento[i] = scanner.nextInt();
            }

            // Verificar si la combinación es correcta y dar pistas
            acertado = true; // Se asume que es correcta, a menos que haya alguna diferencia
            for (int i = 0; i < longitud; i++) {
                if (intento[i] > claveSecreta[i]) {
                    System.out.println(intento[i] + " es mayor.");
                    acertado = false;
                } else if (intento[i] < claveSecreta[i]) {
                    System.out.println(intento[i] + " es menor.");
                    acertado = false;
                } else {
                    System.out.println(intento[i] + " es igual.");
                }
            }

            // Si no se ha acertado la clave, el jugador debe intentarlo de nuevo
            if (!acertado) {
                System.out.println("Intente acertarla de nuevo.");
            } else {
                System.out.println("¡Felicidades! Has acertado la clave secreta.");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}

