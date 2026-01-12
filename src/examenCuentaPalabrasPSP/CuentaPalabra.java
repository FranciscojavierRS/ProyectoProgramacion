package examenCuentaPalabrasPSP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CuentaPalabra {

	public static void main(String[] args) {

		String palabra = args[1].toUpperCase();
		String nombreFichero = args[0];
		String nombreFicheroResultado = args[2];
		
		//Ahora leemos el fichero  y por cada linea obtenemos cada palabra y contamos cuantas veces ha aparecido la palabra en agrs[0]
		
		 int contador = 0;
		 
		 try {
			 PrintWriter ficheroResultado = new PrintWriter(new FileWriter(nombreFicheroResultado,false));
				BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
				
				String linea;
				while ((linea= fichero.readLine())!= null) {
					
					String [] palabrasLineas = linea.split(" ");
					
					for(int i=0; i<palabrasLineas.length; i++) {
						if (palabra.equals(palabrasLineas[i].toUpperCase())) {
							contador++;
						}
					}
					
				}
					
				ficheroResultado.println("La palabra "+ args[1]+" ha aparecido "+contador+" veces");
				System.out.println("La palabra "+ args[1]+" ha aparecido "+contador+" veces");
				fichero.close();
				ficheroResultado.close();
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		

	}

}
