package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class CaculoSalarioSemanalEj6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Cuanas horas trabajaste esta semana?");
		int numeroHoras = sc.nextInt();
		int horas = 12;        
		int horasExtras = 16;  
		int salario;

		if (numeroHoras <= 40)  {

			salario = numeroHoras * horas;
		} else {
			
			int extras = numeroHoras - 40;
			salario = (40 * horas) + (extras * horasExtras);
		}

		System.out.println("En esta semana ganaste " + salario + " euros.");
		
		sc.close();
	}
}
