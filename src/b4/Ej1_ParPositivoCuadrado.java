package b4;

import java.util.Scanner;

public class Ej1_ParPositivoCuadrado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Introduce un número (0 para salir): ");
            numero = sc.nextInt();

            if (numero != 0) {
                // Par o no
                if (numero % 2 == 0) {
                    System.out.println("El número es par.");
                } else {
                    System.out.println("El número es impar.");
                }

                // positivo o negativo
                if (numero > 0) {
                    System.out.println("El número es positivo.");
                } else {
                    System.out.println("El número es negativo.");
                }

                // Calculamos el numero al cuadrado
                System.out.println("El cuadrado del número es: " + (numero * numero));
            }

        } while (numero != 0);

        System.out.println("Programa finalizado.");
        sc.close();
    }
}

