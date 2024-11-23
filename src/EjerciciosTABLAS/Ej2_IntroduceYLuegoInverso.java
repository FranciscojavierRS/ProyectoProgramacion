package EjerciciosTABLAS;

import java.util.Scanner;

public class Ej2_IntroduceYLuegoInverso {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de números que desea introducir
        System.out.print("¿Cuántos números deseas introducir?: ");
        int cantidad = scanner.nextInt();

        // Crear un array para almacenar los números enteros
        int[] numeros = new int[cantidad];

        // Solicitar al usuario que introduzca los números
        System.out.println("Introduce " + cantidad + " números enteros:");

        // Almacenar los números en el array
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Mostrar los números en orden inverso al introducido
        System.out.println("Los números en orden inverso son:");
        for (int i = cantidad - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

        // Cerrar el scanner
        scanner.close();
    }
}
