package EjerciciosChatGptArrays;

import java.util.Scanner;

public class Ej3BuscarUnNumero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] tabla = new int[3][4];

		int numero = 1;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 4; j++) {

				tabla[i][j] = numero;
				numero++;
			}

		}

		System.out.println("Introduce un numero a buscar ");

		int numeroUsuario = sc.nextInt();
		boolean encontrado =false;
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 4; j++) {

				if (tabla[i][j] == numeroUsuario) {
					System.out.println("El numero " + numeroUsuario + " se encuentra en la fila " + (i + 1)
							+ ", columna " + (j + 1));
					encontrado = true;
					break;
					
				}

			}
			if (encontrado) {
				break;
				
			}
		}
		
		if (!encontrado) {
			System.out.println("Numero no encontrado");
		}
		sc.close();

	}

}
