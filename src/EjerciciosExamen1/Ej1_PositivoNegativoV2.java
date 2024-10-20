package EjerciciosExamen1;

import java.util.Scanner;

public class Ej1_PositivoNegativoV2 {

    public static void main(String[] args) {
        // Creación del objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Variables necesarias para realizar los cálculos
        int numero;
        int suma = 0;
        int contador = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int menoresDeCinco = 0;
        boolean mayorDeCien = false;

        // Bucle while para solicitar números al usuario hasta que se introduzca un negativo
        while (true) {
            System.out.print("Introduce un número entero positivo (o un número negativo para terminar): ");
            numero = scanner.nextInt();

            // Si el número es negativo, salir del bucle
            if (numero < 0) {
                break;
            }

            // Sumar los números introducidos
            suma += numero;
            contador++;

            // Comprobar si el número es el mínimo
            if (numero < min) {
                min = numero;
            }

            // Comprobar si el número es el máximo
            if (numero > max) {
                max = numero;
            }

            // Contar cuántos números son menores de 5
            if (numero < 5) {
                menoresDeCinco++;
            }

            // Verificar si hay algún número mayor de 100
            if (numero > 100) {
                mayorDeCien = true;
            }
        }

        // Verificamos si se introdujeron números válidos
        if (contador > 0) {
            // Calcular la media aritmética
            double media = (double) suma / contador;
            System.out.println("Media aritmética de los números introducidos: " + media);

            // Mostrar el valor mínimo
            System.out.println("Valor mínimo: " + min);

            // Mostrar el valor máximo
            System.out.println("Valor máximo: " + max);

            // Calcular y mostrar el porcentaje de números menores de 5
            double porcentajeMenoresDeCinco = (double) menoresDeCinco / contador * 100;
            System.out.println("Porcentaje de números menores de 5: " + porcentajeMenoresDeCinco + "%");

            // Mostrar si hubo algún número mayor de 100
            if (mayorDeCien) {
                System.out.println("Ha habido al menos un número mayor de 100.");
            } else {
                System.out.println("No ha habido ningún número mayor de 100.");
            }
        } else {
            System.out.println("No se han introducido números válidos.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}

