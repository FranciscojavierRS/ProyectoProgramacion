package Ejercicio_Colecciones_CHATGPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/*
 * Cree un ArrayList<Integer>.

Inserte 10 números enteros aleatorios entre 1 y 50.

Muestre:

La lista completa.

El tamaño de la lista.

El mayor número de la lista.

El menor número de la lista.

La suma total de los elementos.

Elimina todos los números pares de la lista.

Muestra la lista resultante.
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		
		ArrayList<Integer> lista = new ArrayList<>();
		
		for (int i= 0; i<10; i++) {
			lista.add((int) (Math.random() * 50)+1);
		}
		
		System.out.println(lista); // vemos la lista
		System.out.println(lista.size()); // obtenemos el tamaño de la linea
		Collections.sort(lista); // obtenemos la lista ordenada
		System.out.println(lista.get(lista.size()-1)); // obtenemos el mayor de la lista
		System.out.println(lista.get(0)); // obtenemos el menor de la lista
		
		int contadorSuma = 0;
		
		for (Integer i: lista) {
			contadorSuma+=i;
		}
		
		System.out.println("la suma de los elementos es :"+contadorSuma);
		
		
		Iterator<Integer> iteradorLista = lista.iterator();
		
		for (; iteradorLista.hasNext();) {
			int numero = (int) iteradorLista.next();
			if(numero%2==0) {
				iteradorLista.remove();
			}
		}
		System.out.println(lista+" Esta es la lista eliminando los numeros pares");

	}

}
