package EjerciciosTABLAS;

import java.util.Scanner;

public class Ej1_5NumerosDecimales {

    public static void main(String[] args) {
        // Crear un array para almacenar 5 números decimales
        double[] numeros = new double[5];

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que introduzca 5 números decimales
        System.out.println("Introduce 5 números decimales:");

        // Recorrer el array para almacenar los números introducidos
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble();
        }

        // Mostrar los números en el mismo orden en que se introdujeron
        System.out.println("Los números introducidos son:");
        for (double numero : numeros) {
            System.out.println(numero);
        }

        // Cerrar el scanner
        scanner.close();
    }
}
