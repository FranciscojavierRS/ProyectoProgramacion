package EjerciciosChatGptArrays;

import java.util.Scanner;

public class Ej5MatrizDeMultiplicar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int[][] tabla = new int[10][2];
		
		System.out.println("Introduce un numero Entero");
		int numeroUsuario = sc.nextInt();
		
		for (int i = 0; i < 10; i++) {
			
			tabla [i][0]=i+1;
			tabla [i][1]=(i+1)*numeroUsuario;
		}
		System.out.println("|Numero || Resultado|");
		for (int i = 0; i < 10; i++) {
			String linea = "";

			for (int j = 0; j < 2; j++) {
				linea += "|"+tabla[i][j] + "|";

			}
			System.out.println(linea);
		}
		

		
		
		
		
		
		
		sc.close();
	}

}
