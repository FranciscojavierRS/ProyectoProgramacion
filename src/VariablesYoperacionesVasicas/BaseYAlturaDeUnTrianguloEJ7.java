package VariablesYoperacionesVasicas;

import java.util.Scanner;

public class BaseYAlturaDeUnTrianguloEJ7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float base;
		float altura;

		System.out.println("Introduceme el Base de un Triangulo");
		base = sc.nextFloat();
		System.out.println("Introduceme la Altura de un Triangulo");
		altura = sc.nextFloat();

		System.out.println(" El Area de estre triangulo es: " + base * altura / 2);
		 sc.close();
	}

}
