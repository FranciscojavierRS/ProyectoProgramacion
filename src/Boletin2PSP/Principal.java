package Boletin2PSP;

import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        // Comprobación de parámetros
        if (args.length != 2) {
            System.out.println("Uso: java Principal <tamArray> <numHilos>");
            return;
        }

        int tamArray = Integer.parseInt(args[0]);
        int numHilos = Integer.parseInt(args[1]);

        // Crear el array
        int[] notas = new int[tamArray];

        // Rellenar el array con valores aleatorios entre 1 y 500
        Random r = new Random();
        for (int i = 0; i < notas.length; i++) {
            notas[i] = r.nextInt(500) + 1;
        }

        // Crear array de hilos
        HiloMaximo[] hilos = new HiloMaximo[numHilos];

        int tamParte = tamArray / numHilos;

        // Crear y lanzar los hilos
        for (int i = 0; i < numHilos; i++) {

            int inicio = i * tamParte;
            int fin;

            // El último hilo coge hasta el final del array
            if (i == numHilos - 1) {
                fin = tamArray;
            } else {
                fin = inicio + tamParte;
            }

            hilos[i] = new HiloMaximo(notas, inicio, fin);
            hilos[i].start();
        }

        // Esperar a que terminen todos los hilos
        try {
            for (int i = 0; i < numHilos; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtener el máximo final
        int maxFinal = hilos[0].getMaximo();

        for (int i = 1; i < numHilos; i++) {
            if (hilos[i].getMaximo() > maxFinal) {
                maxFinal = hilos[i].getMaximo();
            }
        }

        System.out.println("La calificación máxima es: " + maxFinal);
    }
}

