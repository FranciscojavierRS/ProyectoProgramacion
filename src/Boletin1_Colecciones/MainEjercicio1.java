package Boletin1_Colecciones;

import java.util.ArrayList;
import java.util.List;

public class MainEjercicio1 {
	/*
	 * Actividad 1: Crear una colección de 20 números enteros aleatorios menores que
	 * 100, y guardarlos en el orden en que se vayan generando; mostrar por pantalla
	 * dicha lista una vez creada. Ordenarla en sentido creciente y volverla a
	 * mostrar por pantalla.
	 * 
	 */

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			lista.add((int) (Math.random() * 100));

		}
		System.out.println(lista);

		lista.sort(null);

		System.out.println(lista);
	}

}
