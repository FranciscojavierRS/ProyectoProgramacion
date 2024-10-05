package b4;

import java.util.Random;
import java.util.Scanner;

public class Ej3_RandomNumero {

    public static void main(String[] args) {
        // Generar un número aleatorio entre 1 y 100
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;

        // Crear Scanner para capturar la entrada del usuario
        Scanner sc = new Scanner(System.in);
        int intento;

        System.out.println("Adivina el número entre 1 y 100. Introduce -1 para rendirte.");

        // Usamos un bucle while para seguir jugando hasta que acierte o se rinda
        while (true) {
            System.out.print("Introduce un número: ");
            intento = sc.nextInt();

            if (intento == -1) {
                System.out.println("Te has rendido. El número secreto era " + numeroSecreto);
                break;
            }

            if (intento == numeroSecreto) {
                System.out.println("¡Felicidades! Has acertado el número secreto.");
                break;
            } else if (intento < numeroSecreto) {
                System.out.println("El número secreto es mayor.");
            } else {
                System.out.println("El número secreto es menor.");
            }
        }

        sc.close();
    }
}
