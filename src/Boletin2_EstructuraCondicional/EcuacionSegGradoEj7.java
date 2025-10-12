package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class EcuacionSegGradoEj7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los coeficientes (a, b, c): ");
		
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double discriminante = (b * b) - (4 * a * c);
		
		if (a == 0) {
			System.out.println("No es una ecuación de segundo grado (a no puede ser 0).");
		} else if (discriminante > 0) {
			double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
			double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
			System.out.println("La ecuación tiene dos soluciones reales: x1 = " + x1 + " y x2 = " + x2);
		} else if (discriminante == 0) {
			double x = -b / (2 * a);
			System.out.println("La ecuación tiene una solución doble: x = " + x);
		} else {
			System.out.println("La ecuación no tiene soluciones reales.");
		}
		
		sc.close();
	}
}
