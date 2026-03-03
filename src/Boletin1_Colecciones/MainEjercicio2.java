package Boletin1_Colecciones;

import java.util.ArrayList;
import java.util.List;

public class MainEjercicio2 {
	/*
	 * Actividad 2: Repetir el ejercicio anterior, pero ordenar la lista en sentido
	 * decreciente.
	 */
	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			lista.add((int) (Math.random() * 100));

		}
		System.out.println(lista);
		// Esta es la linea en la que tenemos que hacer la modificacion
		lista.sort(null);
		lista= lista.reversed();

		System.out.println(lista);
	}

}
