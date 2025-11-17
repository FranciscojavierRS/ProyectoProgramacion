package EjerciciosChatGptArrays;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		int[][] tabla = new int[3][4];

		int numero = 1;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 4; j++) {

				tabla[i][j] = numero;
				numero++;
			}

		}

		for (int i = 0; i < 3; i++) {
			String linea = "";

			for (int j = 0; j < 4; j++) {
				linea += tabla[i][j] + " ";

			}
			System.out.println(linea);
		}

	}

}
