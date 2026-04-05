package EjercicioFicheroDeTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Ejercicio3 {

	/*
	 * Actividad3: Crear un programa que duplique el conenido de un fichero. Realizar
	dos versiones:
	1. Duplicaremos el fichero original.txt en uno que se llame copia.txt
	2. Pedir el nombre del fichero fuente y duplicarlo en un fichero con el mismo
	nombre con el prefijo "copia_de".
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el fichero original");
		String nombreFichero = sc.next();
		System.out.println("Introduce la version que quieres utilizar (1) (2)");
		int version = sc.nextInt();
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(nombreFichero));
			String ficheroSalida = "";
			if (version == 1) {
				ficheroSalida = "copia.txt";
			} else {
				ficheroSalida = "copia_de" + nombreFichero;
			}
			out = new BufferedWriter(new FileWriter(ficheroSalida, false));

			String linea = in.readLine();

			while (linea != null) {
				out.write(linea);
				linea = in.readLine();
				if (linea != null) {
					out.newLine();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sc.close();

	}

}
