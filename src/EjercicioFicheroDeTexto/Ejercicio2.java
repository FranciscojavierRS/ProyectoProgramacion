package EjercicioFicheroDeTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre");
		String nombreUsuario = sc.next();
		System.out.println("Introduce tu edad");
		int edad = sc.nextInt();
		
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter ("datos.txt",false));
			out.write(nombreUsuario+", "+edad);
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		sc.close();

	}

}
