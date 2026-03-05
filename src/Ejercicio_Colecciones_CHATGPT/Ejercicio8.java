package Ejercicio_Colecciones_CHATGPT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ejercicio8 {

	public static void main(String[] args) {

		List<Integer> listaNumeros = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			listaNumeros.add((int) (Math.random() * 10)+1);

		}
		System.out.println(listaNumeros);
		
		Set<Integer> conjuntoNumeros = new HashSet<>(listaNumeros);
		
		System.out.println(conjuntoNumeros);
		
		Map<Integer, Integer> mapaRepeticiones = new HashMap<>();
		
		for (Integer numero : listaNumeros) {
			if(!mapaRepeticiones.containsKey(numero)) {
				mapaRepeticiones.put(numero, 1);
			}else {
				mapaRepeticiones.put(numero,mapaRepeticiones.get(numero)+1 );

			}
		}
		for (Map.Entry<Integer, Integer>entrada: mapaRepeticiones.entrySet()) {
			System.out.println(entrada.getKey()+" ->"+entrada.getValue());
		}
		
	}

}
