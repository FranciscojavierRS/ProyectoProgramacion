package EjerciciosAngelExcepciones;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class NumerosAInsertar {

	/*
	 * Haz un programa que pregunte al usuario cuántos números va a insertar. Los
	 * insertas. Calculas la media, cual es el máximo, el mínimo y en qué posición
	 * se encontraban esos números (pista, almacena los números que insertes por
	 * teclado en un array). Una vez calculado todo eso, escribe en un fichero la
	 * lista de números, junto con los datos calculados antes
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numerosInsertar = 0;
		System.out.println("¿Cuantos numeros vas a insertar?");
		numerosInsertar = sc.nextInt();
		

		

			int[] tablaNumeros = new int[numerosInsertar];

			for (int i = 0; i < numerosInsertar; i++) {
				System.out.println("Introduce un numero");
				int numeroIntroducido = sc.nextInt();
				tablaNumeros[i] = numeroIntroducido;
			}

			int maximonumeros = tablaNumeros[0];
			int posicionmaxima =tablaNumeros[0];

			int minimonumeros = tablaNumeros[0];
			int posicionminima =tablaNumeros[0];
			
			double sumaNumeros = 0;

			for (int i = 0; i < numerosInsertar; i++) {
				sumaNumeros += tablaNumeros[i];

				if (tablaNumeros[i] > maximonumeros) {
					maximonumeros = tablaNumeros[i];
					posicionmaxima = i;
				}

				if (tablaNumeros[i] < minimonumeros) {
					minimonumeros = tablaNumeros[i];
					posicionminima =i;
				}
			}
			
			

			double media = sumaNumeros / numerosInsertar;

			System.out.println("Numeros introducidos:");
			for (int i = 0; i < numerosInsertar; i++) {
				System.out.println("Posicion " + i + ": " + tablaNumeros[i]);
			}
			
			
			
			
			
			System.out.println("El máximo es el número: " + maximonumeros +" En la posición"+" "+posicionmaxima);
			System.out.println("El minimo es el número: " + minimonumeros +" En la posición"+" "+posicionminima);
			System.out.println("Media: " + media);
			
			

			try {
				FileWriter ArchivoNumeros = new FileWriter("numeros.txt");
				ArchivoNumeros.write("Numeros introducidos:"+"\r\n");
				
				for (int i = 0; i < numerosInsertar; i++) {
					ArchivoNumeros.write("Posicion " + i + ": " + tablaNumeros[i]+"\r\n");
				}
				ArchivoNumeros.write("El máximo es el número: " + maximonumeros +" En la posición"+" "+posicionmaxima+"\r\n");
				
				ArchivoNumeros.write("El minimo es el número: " + minimonumeros +" En la posición"+" "+posicionminima+"\r\n");
				ArchivoNumeros.write("Media: " + media+"\r\n" );
				
				ArchivoNumeros.close();
				
				
				System.out.println("Resultados guardados en numeros.txt");
			} catch (IOException e) {
				
			}

			
		

		sc.close();
	}

}