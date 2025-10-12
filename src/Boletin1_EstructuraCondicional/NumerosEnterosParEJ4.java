package Boletin1_EstructuraCondicional;

import java.util.Scanner;

public class NumerosEnterosParEJ4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número entero: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el segundo número entero: ");
        int num2 = sc.nextInt();

        int contadorPares = 0;

        if (num1 % 2 == 0) {
            contadorPares++;
        }

        if (num2 % 2 == 0) {
            contadorPares++;
        }

        System.out.println("Hay " + contadorPares + " número(s) par(es).");

        sc.close();
    }
}