package b4;

import java.util.Scanner;

public class Ej9_ArbolMasAlto {

	public static void main(String[] args) {
		int indice = 0;
		Scanner sc = new Scanner(System.in);
		int altura = 0;
		int mayor = 0;
		int indiceMayor = 0;
		do {
			System.out.print("Introduce la altura del arbol con ID: " + indice +" (un número negativo para terminar): ");
			altura = sc.nextInt();
			if(altura > mayor) {
				mayor = altura;
				indiceMayor = indice;
			}
		indice ++;

		}while (altura >= 0);
		
		
		System.out.println("el arbol mayor es el "+ indiceMayor);
		sc.close();
	}

}
