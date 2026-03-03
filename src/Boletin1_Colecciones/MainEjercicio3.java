package Boletin1_Colecciones;

import java.util.ArrayList;
import java.util.Random;

public class MainEjercicio3 {

	/*
	 * Crear una colección de 20 números enteros aleatorios (permitiendo repetidos)
	 * menores que 10, guardarlos por orden decreciente a medida que se vayan
	 * generando y mostrar la colección por pantalla.
	 */
	public static void main(String[] args) {

		ArrayList<Integer> lista = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			int numero = random.nextInt(10); // números entre 0 y 9

			// Buscar posición correcta para mantener orden decreciente
			int posicion = 0;
			while (posicion < lista.size() && lista.get(posicion) > numero) {
				posicion++;
			}

			lista.add(posicion, numero);
		}

		System.out.println("Colección ordenada de mayor a menor:");
		System.out.println(lista);

	}

}
