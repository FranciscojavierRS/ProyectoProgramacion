package EjerciciosTABLAS;

import java.util.Scanner;

public class Ej3_Positivonegativo {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de números que desea introducir
        System.out.print("¿Cuántos números deseas introducir?: ");
        int cantidad = scanner.nextInt();

        // Variables para almacenar sumas, contadores y ceros
        int sumaPositivos = 0;
        int sumaNegativos = 0;
        int cuentaPositivos = 0;
        int cuentaNegativos = 0;
        int cuentaCeros = 0;

        // Solicitar al usuario que introduzca los números
        System.out.println("Introduce " + cantidad + " números:");

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();

            // Clasificar el número como positivo, negativo o cero
            if (numero > 0) {
                sumaPositivos += numero;
                cuentaPositivos++;
            } else if (numero < 0) {
                sumaNegativos += numero;
                cuentaNegativos++;
            } else {
                cuentaCeros++;
            }
        }

        // Calcular y mostrar la media de los positivos
        if (cuentaPositivos > 0) {
            double mediaPositivos = (double) sumaPositivos / cuentaPositivos;
            System.out.println("Media de los números positivos: " + mediaPositivos);
        } else {
            System.out.println("No se introdujeron números positivos.");
        }

        // Calcular y mostrar la media de los negativos
        if (cuentaNegativos > 0) {
            double mediaNegativos = (double) sumaNegativos / cuentaNegativos;
            System.out.println("Media de los números negativos: " + mediaNegativos);
        } else {
            System.out.println("No se introdujeron números negativos.");
        }

        // Mostrar la cantidad de ceros
        System.out.println("Cantidad de ceros introducidos: " + cuentaCeros);

        // Cerrar el scanner
        scanner.close();
    }
}
