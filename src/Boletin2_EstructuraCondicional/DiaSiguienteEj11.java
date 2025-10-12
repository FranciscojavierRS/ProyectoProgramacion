package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class DiaSiguienteEj11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el día: ");
		int dia = sc.nextInt();

		System.out.println("Introduce el mes: ");
		int mes = sc.nextInt();

		System.out.println("Introduce el año: ");
		int año = sc.nextInt();

		dia++;

		if (dia > 30) {
			dia = 1;
			mes++;
		}

		if (mes > 12) {
			mes = 1;
			año++;
		}

		System.out.println("La fecha del día siguiente es: " + dia + "/" + mes + "/" + año);

		sc.close();
	}
}
