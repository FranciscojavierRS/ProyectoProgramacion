package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class ValorCircunferenciaEj4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el valor del radio de una cirscunferencia");
		float radio = sc.nextFloat();

		System.out.println("Introduce 1 2 3 dependiendo de la opcion que se quiera ");
		System.out.println("1:Calcular Diametro");
		System.out.println("2:Calcular Perimetro");
		System.out.println("3:Calcular Area");


		int opciones = sc.nextInt();
		switch (opciones) {

		case 1:
			System.out.println("Calcular Diametro");
			System.out.println("El diamtro es "+radio*2);
			break;

		case 2:
			System.out.println("Calcular Perimetro");
			System.out.println("El Perimetro es "+2*Math.PI*radio);

			break;

		case 3:
			System.out.println("Calcular Area");
			System.out.println("El Area es "+radio*radio*Math.PI);

			break;

		}
		sc.close();

	}
}
