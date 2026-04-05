package EjercicioFicheroDeTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre de un fichero");
		String nombreFichero = sc.next();
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader (nombreFichero));
		} catch (FileNotFoundException e) {
			System.out.println("Error: archivo no encontrado leyendo prueba.txt");
			try {
				in = new BufferedReader(new FileReader ("prueba.txt"));
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		}
		
		
		try {
			String linea = in.readLine();
			
			while (linea != null ) {
				System.out.println(linea);
				linea= in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error: al leer la linea");
		}
		
		sc.close();

	}

}
