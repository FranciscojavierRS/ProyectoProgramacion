package EjerciciosChatGptArrays;

import java.util.Scanner;

public class Ej4RellenarTablaPorElUsuario {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] tabla = new int[2][3];

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 3; j++) {

				System.out.println("Introduce el valor para la posición " + (i + 1) + " " + (j + 1));
				int numero = sc.nextInt();

				tabla[i][j] = numero;

			}

		}

		System.out.println("Matriz Introducida: ");

		for (int i = 0; i < 2; i++) {
			String linea = "";

			for (int j = 0; j < 3; j++) {
				linea += tabla[i][j] + " ";

			}
			System.out.println(linea);
		}

		sc.close();
	}

}
