package Boletin1_EstructuraCondicional;

import java.util.Scanner;

public class NumeroPositivoOnoEj1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entero;
		System.out.println("Introduce un numero entero");
		entero = sc.nextInt();

		if (entero >= 0) {
			System.out.println("El numero es positivo");
		} else {
			System.out.println("El numero es negativo");

		}

		sc.close();

	}

}
