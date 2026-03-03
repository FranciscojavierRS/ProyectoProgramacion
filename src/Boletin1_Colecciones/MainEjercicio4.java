package Boletin1_Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainEjercicio4 {
	/*
	 * Introducir por consola una frase que conste exclusivamente de palabras
	 * separadas por espacios. Almacenar en una lista las palabras de la frase, una
	 * en cada nodo y mostrar por pantalla las palabras que estén repetidas. A
	 * continuación, mostrar las que no lo estén.
	 * 
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String frase = sc.nextLine();

		List<String> listaPalabras = new ArrayList<>();

		listaPalabras.addAll(Arrays.asList(frase.split(" ")));

		List<String> listaPalabrasRepetidas = new ArrayList<>();
		List<String> listaPalabrasNoRepetidas = new ArrayList<>();

		for (String palabra : listaPalabras) {
			if (listaPalabras.indexOf(palabra) != listaPalabras.lastIndexOf(palabra)) {
				if(!listaPalabrasRepetidas.contains(palabra))
					listaPalabrasRepetidas.add(palabra);
			} else {
				listaPalabrasNoRepetidas.add(palabra);
			}
		}
		
		System.out.println("Palabras repetidas: "+listaPalabrasRepetidas);
		System.out.println("Palabras  NO repetidas: "+listaPalabrasNoRepetidas);

		sc.close();

	}

}
