package EjercicioFicheroDeTexto;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int contadorPalabras = 1;
		int contadorLineas = 1;
		int contadorCaracteres = 0;
		
		

		try {
			FileReader in = new FileReader ("carta.txt");
			char caracter;
			int c = in.read();
			while(c != -1) {
				caracter=(char)c;
				if(c==' ') {
					contadorPalabras++;
				}else if (c == '\n') {
					contadorLineas++;
					contadorPalabras++;
				}else if(c!= '\r') {
					contadorCaracteres++;
				}
				c = in.read();
			}
			
			
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("El total de Palabras "+contadorPalabras);
		System.out.println("El total de lineas "+contadorLineas);
		System.out.println("El total de Caracteres "+contadorCaracteres);

		
		
		
		sc.close();
		
	}

}
