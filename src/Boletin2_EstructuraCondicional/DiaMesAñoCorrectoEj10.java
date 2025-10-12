package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class DiaMesAñoCorrectoEj10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el día: ");
		int dia = sc.nextInt();

		System.out.println("Introduce el mes: ");
		int mes = sc.nextInt();

		System.out.println("Introduce el año: ");
		int año = sc.nextInt();

		boolean fechaCorrecta = true;
		int diasMes = 0;

		if (mes < 1 || mes > 12) {
			fechaCorrecta = false;
		} else {

			switch (mes) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					diasMes = 31;
					break;
				case 4: case 6: case 9: case 11:
					diasMes = 30;
					break;
				case 2:
					diasMes = 28; 
					break;
			}

			if (dia < 1 || dia > diasMes) {
				fechaCorrecta = false;
			}
		}

		if (fechaCorrecta) {
			System.out.println("La fecha " + dia + "/" + mes + "/" + año + " es correcta.");
		} else {
			System.out.println("La fecha introducida no es válida.");
		}

		sc.close();
	}
}
