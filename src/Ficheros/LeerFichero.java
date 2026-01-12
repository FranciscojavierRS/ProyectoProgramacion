package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

	public static void main(String[] args) {

		try {
			BufferedReader fichero = new BufferedReader(new FileReader("FicheroSaludo.txt"));
			
			String linea;
			while ((linea= fichero.readLine())!= null)
				System.out.println(linea);
			fichero.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
