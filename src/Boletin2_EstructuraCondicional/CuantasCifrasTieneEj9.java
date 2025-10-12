package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class CuantasCifrasTieneEj9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero entre el 0 y el 9999");
		int numero = sc.nextInt();

		if (numero < 10) {
			System.out.println("El numero tiene 1 digito");
		} else if (numero < 100) {
			System.out.println("El numero tiene 2 digitos");
		} else if (numero < 1000) {
			System.out.println("El numero tiene 3 digitos");
		} else {
			System.out.println("El numero tiene 4 digitos");
		}

		sc.close();
	}
}
