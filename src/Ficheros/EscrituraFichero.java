package Ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraFichero {

	public static void main(String[] args) {

		try {
			//PrintWriter fichero = new PrintWriter(new FileWriter("./ficheros/FicheroSaludo.txt",false)); Se pone ./nombre de carpeta/nombre de fichero si quieremos
			// que se guarde en una carpeta en concreto
			PrintWriter fichero = new PrintWriter(new FileWriter("FicheroSaludo.txt",false));

			
			for (int i=1; i<11; i++) {
				fichero.println("Saludo numero: "+i);
				
			}
			fichero.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
