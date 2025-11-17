package Tablas1;

import java.util.Scanner;

public class MediaNumerosEj3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros quieres introducir?");

		int cantidad = sc.nextInt();

		System.out.println("Introduce los numeros");

		int[] numerosDecimales = new int[cantidad];

		for (int i = 0; i < cantidad; i++) {
			int numero = sc.nextInt();
			numerosDecimales[i] = numero;

		}
		
		int cantidadPositivos = 0;
		int cantidadNEgativos = 0;
		int cantidad0Introducidos = 0;
		
		int mediaPositivos = 0;
		int mediaNegativos = 0;
		
		for (int i= 0; i<cantidad; i++) {
			int numero= numerosDecimales[i];
			
			if (numero>0) {
				cantidadPositivos++;
				mediaPositivos=+numero;
				
			}else if (numero<0) {
				cantidadNEgativos++;
				mediaNegativos=+numero;
			}else {
				cantidad0Introducidos++;
			}
				
		}

System.out.println("La media de los positivos es "+ (float)mediaPositivos/cantidadPositivos);
System.out.println("La media de los positivos es "+ (float)mediaNegativos/cantidadNEgativos);
System.out.println("El numero de 0 es "+cantidad0Introducidos);
	}

}
