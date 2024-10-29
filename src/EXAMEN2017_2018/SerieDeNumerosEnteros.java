package EXAMEN2017_2018;

import java.util.Scanner;

public class SerieDeNumerosEnteros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contadorSecuencias = 0; // Contador de secuencias crecientes con al menos 3 números
        int maxLongitudSecuencia = 0; // Longitud de la secuencia creciente más larga
        int longitudSecuenciaActual = 1; // Longitud de la secuencia actual

        System.out.println("Introduce una serie de números enteros. Termina con un número negativo:");
        int numeroAnterior = scanner.nextInt();

        if (numeroAnterior >= 0) {  // Nos aseguramos de que el primer número no es negativo
            while (true) {
                int numeroActual = scanner.nextInt();

                if (numeroActual < 0) {
                    // Al introducir un número negativo, terminamos el programa
                    // y verificamos si la secuencia actual cumple las condiciones
                    if (longitudSecuenciaActual >= 3) {
                        contadorSecuencias++;
                    }
                    maxLongitudSecuencia = Math.max(maxLongitudSecuencia, longitudSecuenciaActual);
                    break;
                }

                if (numeroActual > numeroAnterior) {
                    // Si el número actual es mayor que el anterior, incrementamos la secuencia actual
                    longitudSecuenciaActual++;
                } else {
                    // Si no es creciente, verificamos si la secuencia actual cumple las condiciones
                    if (longitudSecuenciaActual >= 3) {
                        contadorSecuencias++;
                    }
                    // Actualizamos la longitud de la secuencia más larga si es necesario
                    maxLongitudSecuencia = Math.max(maxLongitudSecuencia, longitudSecuenciaActual);
                    longitudSecuenciaActual = 1; // Reiniciamos la longitud de la secuencia
                }

                numeroAnterior = numeroActual;
            }
        }

        // Mostramos el resultado final
        System.out.println("Número de secuencias crecientes de al menos 3 números: " + contadorSecuencias);
        System.out.println("La mayor secuencia tenía " + maxLongitudSecuencia + " números.");

        scanner.close();
    }
}
